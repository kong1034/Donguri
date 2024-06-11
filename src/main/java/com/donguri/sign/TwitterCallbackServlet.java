package com.donguri.sign;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/TwitterCallbackServlet")
public class TwitterCallbackServlet extends HttpServlet {

    private static final String CONSUMER_KEY = "FqekMvj5lFB1Q8iQGOhr55gWe";
    private static final String CONSUMER_SECRET = "csgj05jMLGf6gXSqMt0Ln52zEOrxTxk3V0cvMrAnrpvfJOiyuL";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Twitter twitter = new TwitterFactory().getInstance();
        twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);

        String oauthVerifier = req.getParameter("oauth_verifier");
        RequestToken requestToken = (RequestToken) req.getSession().getAttribute("requestToken");

        try {
            AccessToken accessToken = twitter.getOAuthAccessToken(requestToken, oauthVerifier);
            twitter.setOAuthAccessToken(accessToken);

            // 사용자 정보 가져오기
            twitter4j.User user = twitter.verifyCredentials();
            String screenName = user.getScreenName();
            // 사용자 정보를 세션에 저장 또는 다른 처리
            req.getSession().setAttribute("twitterUser", user);
            req.getSession().setAttribute("screenName", screenName);
            System.out.println("값 받기 성공~");
        } catch (TwitterException e) {
        	System.out.println("실패");
            throw new ServletException("Error getting access token", e);
        }

        resp.sendRedirect("LoginC");
        System.out.println("twitterUser: " + req.getSession().getAttribute("twitterUser"));
        System.out.println("screenName: " + req.getSession().getAttribute("screenName"));
    }
}
