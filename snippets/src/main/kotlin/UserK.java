public class UserK {

    private final String firstName;
    private final String lastName;

    public UserK(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserK user = (UserK) o;

        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        return !(lastName != null ? !lastName.equals(user.lastName) : user.lastName != null);

    }

    @Override public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }

    @Override public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
