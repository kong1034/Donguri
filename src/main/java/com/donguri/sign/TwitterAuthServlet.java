package com.donguri.sign;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.RequestToken;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/TwitterAuthServlet")
public class TwitterAuthServlet extends HttpServlet {

    private static final String CONSUMER_KEY = "FqekMvj5lFB1Q8iQGOhr55gWe";
    private static final String CONSUMER_SECRET = "csgj05jMLGf6gXSqMt0Ln52zEOrxTxk3V0cvMrAnrpvfJOiyuL";
    private static final String CALLBACK_URL = "http://localhost:8080/Donguri/TwitterCallbackServlet";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Twitter twitter = new TwitterFactory().getInstance();
        twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);

        try {
            RequestToken requestToken = twitter.getOAuthRequestToken(CALLBACK_URL);
            req.getSession().setAttribute("requestToken", requestToken);
            resp.sendRedirect(requestToken.getAuthenticationURL());
        } catch (TwitterException e) {
            throw new ServletException("Error getting request token", e);
        }
    }
}
