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

            // Get Twitter user information
            twitter4j.User user = twitter.verifyCredentials();
            String screenName = user.getScreenName();//user id in Twitter
            // set Session Twitter user information for register in DB
            XUserDTO xuser = new XUserDTO();
            xuser.setX_id(screenName);
            req.getSession().setAttribute("twitterUser", xuser);
            System.out.println("successe getting Twitter User information.");
        } catch (TwitterException e) {
        	System.out.println("Server Error in Twitter Call Back Servlet.");
            throw new ServletException("Error getting access token", e);
        }
        
        resp.sendRedirect("XLoginC");
        System.out.println("twitterUser: " + req.getSession().getAttribute("twitterUser"));
    }
}
