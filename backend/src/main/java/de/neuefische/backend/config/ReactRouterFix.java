package de.neuefische.backend.config;

import org.springframework.web.bind.annotation.RequestMapping;

public class ReactRouterFix {
    @RequestMapping(value = "/**/{[path:[^\\.]*}")
    public String forwardToRouteUrl() {
        return "forward:/";
    }
}
