package patterns;

public class MainBuilder {

    public static void main(String... args) {
        User user = User.getBuilder().name("Вася").age(25).build();
        System.out.println(user.getName());
        System.out.println(user.getAge());
    }
}

class User {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static Builder getBuilder() {
        return new User().new Builder();
    }

    class Builder {
        public Builder name(String name) {
            User.this.name = name;
            return this;
        }

        public Builder age(int age) {
            User.this.age = age;
            return this;
        }

        public User build() {
            return User.this;
        }
    }
}