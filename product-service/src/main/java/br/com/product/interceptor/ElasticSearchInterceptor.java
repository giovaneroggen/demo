package br.com.product.interceptor;

import org.apache.logging.log4j.util.Strings;
import org.springframework.data.elasticsearch.core.mapping.DynamicIndexAndTypeContextHolder;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

/**
 * Created by giovane.silva on 02/10/2017.
 */
public class ElasticSearchInterceptor extends HandlerInterceptorAdapter implements Filter, Serializable {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        DynamicIndexAndTypeContextHolder instance = DynamicIndexAndTypeContextHolder.getInstance();
        String organizationId = this.getRequestAttribute(request, DynamicIndexAndTypeContextHolder.ORGANIZATION_ID);
        String storeId = this.getRequestAttribute(request, DynamicIndexAndTypeContextHolder.STORE_ID);
        instance.setIndexAndType(organizationId, storeId);
        return true;
    }

    public String getRequestAttribute(HttpServletRequest request, String key){
        Map<String, String> map = (Map) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        if(map.containsKey(key)){
            return map.get(key);
        }else {
            String parameter = request.getParameter(key);
            if(Strings.isNotBlank(parameter)){
                return parameter;
            }
        }
        return null;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            this.preHandle((HttpServletRequest)request, (HttpServletResponse)response, null);

            try{
                chain.doFilter(request, response);
            }finally{
                this.postHandle((HttpServletRequest)request, (HttpServletResponse)response, null, null);
            }

        } catch (Exception ex) {
            throw new IOException(ex);
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        DynamicIndexAndTypeContextHolder.getInstance().clean();
    }

    @Override
    public void destroy() {

    }
}
