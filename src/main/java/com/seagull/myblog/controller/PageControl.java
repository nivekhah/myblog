package com.seagull.myblog.controller;

import com.seagull.myblog.service.ArticleService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Seagull_gby
 * @date 2019/1/20 21:19
 * Description: 文章显示页面
 */

@Controller
public class PageControl {

    @Autowired
    private ArticleService articleService;

    /**
     * 文章跳转
     * @param articleId 文章ID
     * @param model 页面间传值
     * @return 文章页面
     */
    @GetMapping("/article/{articleId}")
    public String stepArticle(@PathVariable("articleId") long articleId, Model model) {
        model.addAttribute("articleId", articleId);

        return "article";
    }

    /**
     * 获得文章内容
     * @param request 请求域
     * @return 指定JSON
     */
    @ResponseBody
    @RequestMapping("/getArticleContent")
    public JSONObject articleContent(HttpServletRequest request) {
        JSONObject returnArticleContent = new JSONObject();

        long articleId = Long.valueOf(request.getParameter("articleId"));

        returnArticleContent = articleService.getArticlesContent(articleId);

        return returnArticleContent;
    }
}
