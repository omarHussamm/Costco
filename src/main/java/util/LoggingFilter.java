package util;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class LoggingFilter extends OncePerRequestFilter {

    private final Logger logger = LoggerFactory.getLogger(LoggingFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, jakarta.servlet.FilterChain filterChain) throws jakarta.servlet.ServletException, IOException {
        HttpServletRequest httpRequest = request;
        HttpServletResponse httpResponse = response;

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        try {
            // Log the incoming request
            logger.info("Incoming request - Method: {}, Path: {}", request.getMethod(), request.getRequestURI());

            // Proceed with the request
            filterChain.doFilter(request, response);

            stopWatch.stop(); // Stop the timing here

            if (stopWatch.getTotalTimeMillis() > 5000) {
                logger.error("Response time exceeded threshold - Time: {} ms", stopWatch.getTotalTimeMillis());
            } else {
                logger.info("Outgoing response - Status: {}, Time: {} ms, Content: {}", response.getStatus(), stopWatch.getTotalTimeMillis(), httpResponse.getContentType());
            }
        } catch (Exception ex) {
            logger.error("Error occurred during request processing", ex);
            throw ex;
        }
    }
}