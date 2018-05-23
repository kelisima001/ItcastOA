package cn.itcast.oa.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ComponentTagSupport;

import com.opensymphony.xwork2.util.ValueStack;

public class ATag extends ComponentTagSupport{

	private static final long serialVersionUID = 1L;
	private String actionURL;
    private String value;
    private String onclick = "";

    @Override
    public Component getBean(ValueStack valueStack, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        return new AComponent(valueStack, httpServletRequest);
    }

    @Override
    protected void populateParams() {
        AComponent component = (AComponent) getComponent();
        component.setActionURL(actionURL);
        component.setValue(value);
        component.setOnclick(onclick);
    }

    public String getOnclick() {
        return onclick;
    }

    public void setOnclick(String onclick) {
        this.onclick = onclick;
    }

    public String getActionURL() {
        return actionURL;
    }

    public void setActionURL(String actionURL) {
        this.actionURL = actionURL;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

	
}
