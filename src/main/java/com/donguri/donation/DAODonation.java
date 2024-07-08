package com.donguri.donation;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.donguri.main.DBManager;
import com.donguri.sign.UserDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class DAODonation {
    private Connection con = null;
    private List<DTODonation> donations;
    private List<Integer> imgCntList;
    public static final DAODonation RDAO = new DAODonation();

    private DAODonation() {
        try {
            con = DBManager.connect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getDonationByOne(HttpServletRequest request, HttpServletResponse response) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        DTODonation donation = null;
        String donationNo = request.getParameter("no");

        String sql = "SELECT dd.d_title, dd.d_content, dd.d_date, dd.d_thumnail, dd.d_amount, COALESCE(SUM(dp.p_price), 0) AS sum, dd.d_created_date, dd.d_publisher, dd.d_tags "
                   + "FROM d_donation_list dd "
                   + "LEFT JOIN d_payment dp ON dd.d_no = dp.d_no "
                   + "WHERE dd.d_no = ? "
                   + "GROUP BY dd.d_no, dd.d_title, dd.d_content, dd.d_date, dd.d_thumnail, dd.d_amount, dd.d_created_date, dd.d_publisher, dd.d_tags";

        try {
            System.out.println("Executing SQL: " + sql);

            con = DBManager.connect();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, donationNo);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                donation = new DTODonation();
                donation.setTitle(rs.getString("d_title"));

                String content = rs.getString("d_content");
                content = content.replaceAll("<br>", "\r\n");
                donation.setContent(content);

                String date = rs.getString("d_date");
                donation.setDate(date);

                donation.setThumnail(rs.getString("d_thumnail"));
                donation.setAmount(rs.getInt("d_amount"));
                donation.setSum(rs.getInt("sum"));
                donation.setCreated_date(rs.getString("d_created_date"));
                donation.setPublisher(rs.getString("d_publisher"));
                donation.setTag(rs.getString("d_tags"));

                // Calculate the percentage and imgCnt here
                int amount = rs.getInt("d_amount");
                int sum = rs.getInt("sum");

                System.out.println("==============");
                System.out.println("check amount => " + amount);
                System.out.println("check sum => " + sum);

                double percentage = ((double) sum / amount) * 100;

                System.out.println("check percentage => " + percentage);

                int imgCnt = (int) (percentage / 10);

                System.out.println("check imgCnt => " + imgCnt);
                System.out.println("==============");

                // Set attributes for the request
                request.setAttribute("percentage", percentage);
                request.setAttribute("imgCnt", imgCnt);
                request.setAttribute("selected_info", donation);
            } else {
                // Prevent further null pointer exceptions
                request.setAttribute("selected_info", new DTODonation());
                request.setAttribute("percentage", 0.0);
                request.setAttribute("imgCnt", 0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.close(con, pstmt, rs);
        }
    }

    // Method to get donation details by user ID
    public void getDonationById(HttpServletRequest request) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        HttpSession session = request.getSession();
        UserDTO user = (UserDTO) session.getAttribute("user");

        String userId = user.getU_id();
        String sqlSum = "SELECT SUM(p_price) AS total_donation FROM d_payment WHERE u_id=?";
        String sqlCount = "SELECT COUNT(*) AS count_donation FROM d_payment WHERE u_id=?";
        String sqlDTitle = "SELECT dp.u_id, dp.d_no, dd.d_title "
                + "FROM d_payment dp "
                + "LEFT JOIN d_donation_list dd ON dp.d_no = dd.d_no WHERE dp.u_id=?";

        try {
            con = DBManager.connect();
            pstmt = con.prepareStatement(sqlSum);
            pstmt.setString(1, userId);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                int totalDonation = rs.getInt("total_donation");
                request.setAttribute("totalD", totalDonation);
            }

            pstmt = con.prepareStatement(sqlCount);
            pstmt.setString(1, userId);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                int countDonation = rs.getInt("count_donation");
                request.setAttribute("countD", countDonation);
            }
            pstmt = con.prepareStatement(sqlDTitle);
            pstmt.setString(1, userId);
            rs = pstmt.executeQuery();

            List<DTODonation> d_title = new ArrayList<>();
            DTODonation dn = null;
            while (rs.next()) {
                dn = new DTODonation();
                dn.setTitle(rs.getString("d_title"));
                d_title.add(dn);
            }
            request.setAttribute("dTitle", d_title);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(con, pstmt, rs);
        }
    }

    // Method to get all donations
    public void getAllDonations(HttpServletRequest request, HttpServletResponse response) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        donations = new ArrayList<DTODonation>();
        imgCntList = new ArrayList<Integer>();
        String sql = "select dd.d_no, dd.d_title, dd.d_date, dd.d_thumnail, dd.d_amount, coalesce(sum(dp.p_price), 0) as SUM"
                + " from d_donation_list dd" + " left join d_payment dp" + " on dd.d_no = dp.d_no"
                + " group by dd.d_no, dd.d_title, dd.d_date, dd.d_thumnail, dd.d_amount" + " order by dd.d_no desc";

        try {
            con = DBManager.connect();
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int imgCnt = 0;
                DTODonation donation = new DTODonation();
                donation.setNo(rs.getInt("d_no"));
                donation.setTitle(rs.getString("d_title"));
                donation.setDate(rs.getString("d_date"));
                donation.setThumnail(rs.getString("d_thumnail"));
                donation.setAmount(rs.getInt("d_amount"));
                donation.setSum(rs.getInt("SUM"));

                int amount = rs.getInt("d_amount");
                int sum = rs.getInt("SUM");

                System.out.println("==============");
                System.out.println("check amount => " + amount);
                System.out.println("check sum => " + sum);

                double percentage = ((double) sum / amount) * 100;

                System.out.println("check percentage => " + percentage);

                imgCnt = (int) (percentage / 10);

                donations.add(donation);
                System.out.println("check imgCnt => " + imgCnt);
                System.out.println("==============");
                imgCntList.add(imgCnt);
                System.out.println("check imgCntList => " + imgCntList);
            }

            request.setAttribute("donationList", donations);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(con, pstmt, rs);
        }
    }

    // Method for pagination
    public void paging(int page, HttpServletRequest request) {

        int cnt = 8; // show page count
        int total = donations.size(); // show page data count
        int totalPage = (int) Math.ceil((double) total / cnt); // total page count

        // start index & end index
        int start = (page - 1) * cnt;
        int end = Math.min(start + cnt, total);

        ArrayList<DTODonation> dItems = new ArrayList<DTODonation>();
        ArrayList<Integer> pagedImgCntList = new ArrayList<Integer>();

        for (int i = start; i < end; i++) {
            dItems.add(donations.get(i));
            pagedImgCntList.add(imgCntList.get(i));
        }

        request.setAttribute("pageCnt", totalPage);
        request.setAttribute("curPageNo", page);
        request.setAttribute("dItems", dItems);
        request.setAttribute("pagedImgCntList", pagedImgCntList);
    }

    // Method to create a new donation
    public void postDonationMake(HttpServletRequest request, HttpServletResponse response) {
        PreparedStatement pstmt = null;
        String sql = "insert into d_donation_list values(d_donation_list_seq.nextval, default, ?,?,?,?,?,?,?, default)";

        try {
            con = DBManager.connect();
            
            String path = request.getServletContext().getRealPath("img/server");
            MultipartRequest mr = new MultipartRequest(request, path, 1024 * 1024 * 20, "utf-8",
                    new DefaultFileRenamePolicy());

            String title = mr.getParameter("title");
            String content = mr.getParameter("content");
            String thumbnail = mr.getFilesystemName("thumbnail");
            int amount = Integer.parseInt(mr.getParameter("amount"));
            String end_date = mr.getParameter("end_date");
            String publisher = mr.getParameter("publisher");
            String tag = mr.getParameter("tag");

            LocalDate localDateTime = LocalDate.parse(end_date);
            Date date = Date.valueOf(localDateTime);

            content = content.replaceAll("<br>", "\r\n");
            
            System.out.println("check title in dao => " + title);
            System.out.println("check content in dao => " + content);
            System.out.println("check thumbnail in dao => " + thumbnail);
            System.out.println("check amount in dao => " + amount);
            System.out.println("check date in dao => " + date);
            System.out.println("check publisher in dao => " + publisher);
            System.out.println("check tag in dao => " + tag);

            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, title);
            pstmt.setString(2, content);
            pstmt.setString(3, thumbnail);
            pstmt.setInt(4, amount);
            pstmt.setDate(5, date);
            pstmt.setString(6, publisher);
            pstmt.setString(7, tag);

            if (pstmt.executeUpdate() == 1) {
                System.out.println("Insert successful");
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Server error");
        } finally {
            DBManager.close(con, pstmt, null);
        }
    }

    // Method to update a donation
    public void postDonationUpdate(HttpServletRequest request, HttpServletResponse response) {
        PreparedStatement pstmt = null;
        String sql = "update d_donation_list set" + " d_title = ?," + " d_content = ?," + " d_thumnail = ?,"
                + " d_amount = ?," + " d_date = ?," + " d_publisher = ?," + " d_tags = ?" + " where d_no = ?";

        try {
            con = DBManager.connect();
            String path = request.getServletContext().getRealPath("img/server");
            MultipartRequest mr = new MultipartRequest(request, path, 1024 * 1024 * 20, "utf-8",
                    new DefaultFileRenamePolicy());
            
            int no = Integer.parseInt(mr.getParameter("no"));
            String title = mr.getParameter("title");
            String content = mr.getParameter("content");
            String thumbnail = mr.getFilesystemName("thumbnail");
            int amount = Integer.parseInt(mr.getParameter("amount"));
            String end_date = mr.getParameter("end_date");
            String publisher = mr.getParameter("publisher");
            String tag = mr.getParameter("tag");

            LocalDate localDate = LocalDate.parse(end_date);
            Date date = Date.valueOf(localDate);

            content = content.replaceAll("\r\n", "<br>");
            
            System.out.println("check no in dao => " + no);
            System.out.println("check title in dao => " + title);
            System.out.println("check content in dao => " + content);
            System.out.println("check thumbnail in dao => " + thumbnail);
            System.out.println("check amount in dao => " + amount);
            System.out.println("check date in dao => " + date);
            System.out.println("check publisher in dao => " + publisher);
            System.out.println("check tag in dao => " + tag);

            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, title);
            pstmt.setString(2, content);
            pstmt.setString(3, thumbnail);
            pstmt.setInt(4, amount);
            pstmt.setDate(5, date);
            pstmt.setString(6, publisher);
            pstmt.setString(7, tag);
            pstmt.setInt(8, no);

            if (pstmt.executeUpdate() == 1) {
                System.out.println("Update successful");
                response.setStatus(HttpServletResponse.SC_OK);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Server error");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } finally {
            DBManager.close(con, pstmt, null);
        }
    }
}