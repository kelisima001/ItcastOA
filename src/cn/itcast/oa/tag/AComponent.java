package cn.itcast.oa.tag;

import java.io.IOException;
import java.io.Writer;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.components.Component;
import cn.itcast.oa.domain.User;
import com.opensymphony.xwork2.util.ValueStack;

public class AComponent  extends Component{
	private String actionURL;
    private String value;
    private String onclick = "";
    private HttpServletRequest request;

    @Override
    public boolean start(Writer writer) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user.hasPrivilegeByUrl(actionURL)) {
            try {
                writer.write("<a href='" + formatURL(actionURL) + "' onClick='" + onclick + "'>" + value + "</a>");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        } else {
            return super.start(writer);
        }
    }

    private String formatURL(String url) {
        int index = url.indexOf('?');
        if (index != -1) {
            String params = url.substring(index);
            url = url.substring(0, index) + ".action" + params;
        } else {
            url = url + ".action";
        }
        return url;
    }

    public AComponent(ValueStack stack, HttpServletRequest request) {
        super(stack);
        this.request = request;
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

    public String getOnclick() {
        return onclick;
    }

    public void setOnclick(String onclick) {
        this.onclick = onclick;
    }
}
