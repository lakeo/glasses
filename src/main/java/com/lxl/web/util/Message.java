package com.lxl.web.util;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.HashMap;

/**
 * A message to be displayed in web context. Depending on the type, different style will be applied.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Message implements java.io.Serializable {
    /**
     * Name of the flash attribute.
     */
	public static final String MESSAGE_ATTRIBUTE = "message";

    /**
     * The type of the message to be displayed. The type is used to show message in a different style.
     */
	public static enum Type {
        DANGER(2), WARNING(1), INFO(3), SUCCESS(0);
		private int index;
		Type(int index){
			this.index = index;
		}

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}
	}

	private String message;
	private int type;
	private HashMap args;

	public Message()
	{
		this.message = "404";
		this.type = Type.SUCCESS.getIndex();
		this.args = new HashMap();
	}
	public Message(String message, Type type) {
		this.message = message;
		this.type = type.getIndex();
		this.args = new HashMap();
	}
	
	public Message(String message, Type type, HashMap args) {
		this.message = message;
		this.type = type.getIndex();
		this.args = args;
	}

	public void setType(int type) {
		this.type = type;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setType(Type type) {
		this.type = type.getIndex();
	}

	public void setArgs(HashMap  args) {
		this.args = args;
	}

	public String getMessage() {
		return message;
	}

	public int getType() {
		return type;
	}

	public HashMap getArgs() {
		return args;
	}

	public void putData(Object o)
	{
		this.args.put("data",o);
	}
	public void putError(Object o)
	{
		this.args.put("error",o);
	}
}
