package lenny.sc.sczuul;

import ch.qos.logback.classic.Logger;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class ParameterFilter extends ZuulFilter {
    private org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getRootLogger();

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("Prefilter is invoked, %s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        Object accessToken = request.getParameter("name");
        if (accessToken == null) {
            log.warn("name is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            } catch (Exception e) {
            }

            return null;
        }
        log.info("ok");
        return "OK";
    }
}
