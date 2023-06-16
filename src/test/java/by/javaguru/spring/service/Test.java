package by.javaguru.spring.service;

public class Test {
    private final String a;

    public Test(String a) {
        this.a = a;
    }

    public static void main(String[] args) {
        String s1 = new String("a");
        String s2 = new String("a");
        String s3 = "a";
        String s4 = "a";
        System.out.println(s3.equals(s4));
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
        s2.intern();
        System.out.println(s2.equals(s3));
    }

    public String getA() {
        return this.a;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Test)) return false;
        final Test other = (Test) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$a = this.getA();
        final Object other$a = other.getA();
        if (this$a == null ? other$a != null : !this$a.equals(other$a)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Test;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $a = this.getA();
        result = result * PRIME + ($a == null ? 43 : $a.hashCode());
        return result;
    }

    public String toString() {
        return "Test(a=" + this.getA() + ")";
    }
}
