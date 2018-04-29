package com.example.demo.config;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: Bob Simon
 * @Description: 通用访问拦截匹配
 * @Date: Created in 9:37 2018\4\29
 */
@Controller
public class IndexController {
	
	/**
	 * 页面跳转
	 * @param module
	 * @param url
	 * @return
	 */
	@RequestMapping("{url}.shtml")
	public String page(@PathVariable("url") String url) {
		return  url;
	}

	/**
	 * 页面跳转(二级目录)
	 * @param module
	 * @param function
	 * @param url
	 * @return
	 */
	@RequestMapping("{module}/{url}.shtml")
	public String page(@PathVariable("module") String module,@PathVariable("url") String url) {
		return module + "/" + url;
	}
	
}
