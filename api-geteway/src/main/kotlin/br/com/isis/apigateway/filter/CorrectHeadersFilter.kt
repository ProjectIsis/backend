package br.com.isis.apigateway.filter

import com.netflix.zuul.ZuulFilter
import com.netflix.zuul.context.RequestContext
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

/**
 * Created by gaspar on 08/05/2017.
 */
@Order(2)
@Component
class CorrectHeadersFilter : ZuulFilter() {

    override fun filterType(): String {
        return "pre"
    }

    override fun filterOrder(): Int {
        return 10000
    }

    override fun shouldFilter(): Boolean {
        return true
    }

    override fun run(): Any? {
        val currentContext = RequestContext.getCurrentContext()

        currentContext.addZuulRequestHeader("host", currentContext.request.getHeader("host"))

        currentContext.zuulRequestHeaders.remove("x-forwarded-prefix")

        (currentContext["ignoredHeaders"] as MutableSet<*>).clear()
        return null
    }

}