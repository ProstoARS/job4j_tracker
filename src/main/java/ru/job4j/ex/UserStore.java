package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User rsl = null;
        for(User str : users) {
            if(str.getUsername().equals(login)) {
                rsl = str;
            }
        }
        if(rsl == null) {
            throw new UserNotFoundException("User not found");
        }
        return rsl;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if(user.isValid() && user.getUsername().length() > 2) {
            return true;
        } else {
            throw new UserInvalidException("User Invalid");
        }
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };


        try {
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException ei) {
            ei.printStackTrace();
        } catch (UserNotFoundException en) {
            en.printStackTrace();
        }
    }
}
