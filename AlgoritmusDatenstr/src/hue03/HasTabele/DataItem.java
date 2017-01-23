package hue03.HasTabele;

public class DataItem {

	private Object Key;
	private Object Value;

	public DataItem(Object Key, Object Value) {
		this.Key = Key;
		this.Value = Value;
	}

	public DataItem(Object Value) {
		this.Value = Value;
	}

	public Object getKey() {
		return Key;
	}

	public Object getValue() {
		return Value;
	}

	public void setKey(Object key) {
		Key = key;
	}

	public void setValue(Object value) {
		Value = value;
	}

}
