package br.com.codenation;

public class Element {
    public int getValue() {
        return Value;
    }

    private int Value;

    public Element(int value) {
        Value = value;
        setCount(0);
    }

    public int getCount() {
        return Count;
    }

    public boolean IncrementCount()
    {
        Count++;
        return true;
    }

    public void setCount(int count) {
        Count = count;
    }

    private int Count;

    @Override
    public boolean equals(Object obj) {
        Element element = (Element) obj;
        return Value == element.Value;
    }
}
