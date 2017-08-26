package ash.test.custom.tag;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

/**
 * @author ashikur rahman
 * @difficulty beginner
 * */

@SuppressWarnings("serial")
public class CustomTagHandler extends BodyTagSupport {
	
	private String operation = "";
	private int lower = 0;
	private int upper = 0;
	
	public int getLower() {
		return lower;
	}

	public void setLower(int lower) {
		Objects.requireNonNull(lower);
		if(lower<0)
			this.lower = 0;
		this.lower = lower;
	}

	public int getUpper() {
		return upper;
	}

	public void setUpper(int upper) {
		Objects.requireNonNull(upper);
		if(upper<0)
			this.upper = 0;
		this.upper = upper;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public int doAfterBody() throws JspException {
		BodyContent bodycontent = getBodyContent();
		JspWriter out = bodycontent.getEnclosingWriter();
		String body = bodycontent.getString();
		try {
			if(operation.equals("reverse"))
				out.println(reverseStr(body));
			if(operation.equals("length"))
				out.println(strLen(body));
			if(operation.equals("uppercase"))
				out.println(upperCase(body));
			if(operation.equals("lowercase"))
				out.println(lowerCase(body));
			if(operation.equals("substring"))
				out.println(genSubString(body, lower, upper));
		} catch(NullPointerException | IOException npe) {
			npe.getMessage();
		}
		return SKIP_BODY;
	}
	
	private String reverseStr(String param) throws NullPointerException {
		Objects.requireNonNull(param);
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(param);
		return stringBuffer.reverse().toString();
	}
	
	private int strLen(String param) throws NullPointerException {
		Objects.requireNonNull(param);
		return param.length();
	}
	
	private String upperCase(String param) throws NullPointerException {
		Objects.requireNonNull(param);
		return param.toUpperCase();
	}
	
	private String lowerCase(String param) throws NullPointerException {
		Objects.requireNonNull(param);
		return param.toLowerCase();
	}
	
	private String genSubString(String param, int lower, int upper) throws NullPointerException {
		Objects.requireNonNull(param);
		return param.substring(lower, upper);
	}
}
