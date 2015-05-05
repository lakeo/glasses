package com.lxl.web.util;

import java.util.HashMap;
import java.util.Map;

/**
 * A message to be displayed in web context. Depending on the type, different style will be applied.
 */
public class Message implements java.io.Serializable {
    /**
     * Name of the flash attribute.
     */
	public static final String MESSAGE_ATTRIBUTE = "message";

    /**
     * The type of the message to be displayed. The type is used to show message in a different style.
     */
	public static enum Type {
        DANGER, WARNING, INFO, SUCCESS;
	}

	private String message;
	private Type type;
	private HashMap args;

	public Message()
	{
		this.message = "404";
		this.type = Type.INFO;
		this.args = new HashMap();
	}
	public Message(String message, Type type) {
		this.message = message;
		this.type = type;
		this.args = new HashMap();
	}
	
	public Message(String message, Type type, HashMap args) {
		this.message = message;
		this.type = type;
		this.args = args;
	}

	public void putData(Object o)
	{
		this.args.put("data",o);
	}
	public void putError(Object o)
	{
		this.args.put("error",o);
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public void setArgs(HashMap  args) {
		this.args = args;
	}

	public String getMessage() {
		return message;
	}

	public Type getType() {
		return type;
	}

	public HashMap getArgs() {
		return args;
	}
}
