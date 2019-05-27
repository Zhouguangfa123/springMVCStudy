package com.commom;

import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * TokenTools
 *
 * @author zhougf
 * @date 2019/5/27
 */
public class TokenTools {
    /**
     * 生成token放入session
     * @param request
     * @param tokenServerKey
     */
    public static String getToken(HttpServletRequest request, String tokenServerKey, Map<String, String> params){
        TokenFactory tokenFactory = TokenFactory.getInstance();
        String token = tokenFactory.makeToken(params);
        request.getSession().setAttribute(tokenServerKey, token);
        return token;
    }

    /**
     * 移除token
     * @param request
     * @param tokenServerKey
     */
    public static void removeToken(HttpServletRequest request, String tokenServerKey){
        request.getSession().removeAttribute(tokenServerKey);
    }

    /**
     * 判断请求参数中的token是否和session中一致
     * @param request
     * @param tokenClientKey
     * @param tokenServerKey
     * @return
     */
    public static boolean judgeTokenIsEqual(HttpServletRequest request, String tokenClientKey, String tokenServerKey){
//        String token_client = request.getParameter(tokenClientKey);
        String token_client = request.getHeader(tokenClientKey);
        if(StringUtils.isEmpty(token_client)){
            return false;
        }
        String token_server = (String) request.getSession().getAttribute(tokenServerKey);
        if(StringUtils.isEmpty(token_server)){
            return false;
        }

        if(!token_server.equals(token_client)){
            return false;
        }

        return true;
    }
}
