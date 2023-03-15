package org.cdb.antlr.parser;

public class ValObj {
    public static final int STRING_TYPE = 1;
    public static final int LONG_TYPE   = 2;
    public static final int BOOL_TYPE   = 3;

    public int type;
    public Object value;

    public ValObj() {
    }

    public ValObj(int type, Object v) {
        this.type = type;
        this.value = v;
    }

    public ValObj(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.value.toString();
    }

    public int compareTo(ValObj obj) {
        System.out.println("this type: " + this.type + " obj type: " + obj.type);
        System.out.println("this type: " + this.value + " obj type: " + obj.value);
        if (this.type == LONG_TYPE && obj.type == LONG_TYPE) {
            Long left  = (Long)this.value;
            Long right = (Long)obj.value;
            return left.compareTo(right);
        } else if (this.type == LONG_TYPE) {
            Long left  = (Long)this.value;
            String tmp = obj.value.toString();
            if (tmp.isEmpty()) {
                tmp = "0";
            }
            Long right = Long.parseLong(tmp);
            return left.compareTo(right);
        } else if (obj.type == LONG_TYPE) {
            String tmp = this.value.toString();
            System.out.println("tmp = " + tmp + " value = " + this.value);
            if (tmp.isEmpty()) {
                tmp = "0";
            }
            Long left  = Long.parseLong(tmp);
            Long right = (Long) obj.value;
            return left.compareTo(right);
        } else if (obj.type == BOOL_TYPE) {
            Boolean left  = (Boolean)this.value;
            Boolean right = (Boolean) obj.value;
            return  left.compareTo(right);
        } else {
            System.out.println("left = " + this.value + " right = " + obj.value);
            String left  = String.valueOf(this.value);
            String right = String.valueOf(obj.value);
            System.out.println("left = " + left + " right = " + right);
            return left.compareTo(right);
        }
    }

    public ValObj arithmetic(ValObj obj, char op) {
        ValObj result = new ValObj();
        result.type = LONG_TYPE;
        result.value = -1L;
        if (this.type != LONG_TYPE || obj.type != LONG_TYPE) {
            return result;
        }
        switch (op) {
            case '+':
                result.value = (Long) this.value + (Long) obj.value;
                break;
            case '-':
                result.value = (Long) this.value - (Long) obj.value;
                break;
            case '*':
                result.value = (Long) this.value * (Long) obj.value;
                break;
            case '/':
                result.value = (Long) this.value / (Long) obj.value;
                break;
            default:
                break;
        }
        return result;
    }

    public boolean isZero() {
        return type == LONG_TYPE && (Long)value == 0L;
    }

    public boolean isOne() {
        return type == LONG_TYPE && (Long)value != 0L;
    }
}
