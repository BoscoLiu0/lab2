![image](./Title.jpg)

# Part 1:
##  code for StringServer：
```
import java.io.IOException;
import java.net.URI;

class Handler implements URLHandler {
    int num = 0;
    public String handleRequest(URI url) {
            if (url.getPath().contains("/add")) {
                String[] parameters = url.getQuery().split("=");
                if (parameters[0].equals("count")) {
                    num += Integer.parseInt(parameters[1]);
                    return String.format("Number increased by %s! It's now %d", parameters[1], num);
                }
            }
            return "404 Not Found!";
        }
    }
}

class NumberServer {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}
```
1.Hello

![image](./Hello.jpg)

2.How are you

![image](./Howareyou.jpg)
### a.Which methods in your code are called?
handleRequest method.
### b.What are the relevant arguments to those methods, and the values of any relevant fields of the class?
arguments are the URL and UCI，The UCI includes the path and query. Relevant fields are ```String s``` and ```int num```. ```String s``` is used to add and hold strings from add-messages. ```int num``` is used to show how many single strings we put.
### c.How do the values of any relevant fields of the class change from this specific request? If no values got changed, explain why.
Path: ```/add```Query Parameters: ```count=5``` considering the example URL: `num` `http://localhost:8080/add?count=5` and so on. If there are subsequent requests with different "count" values, the  field will continue to be updated accordingly. If the request doesn't meet the specified conditions (e.g., incorrect path or parameter name), the  field remains unchanged.`num` `num`.

# Part 2:
### The path to the private key for your SSH key for logging into ieng6 (on your computer or on the home directory of the lab computer)

![image](./part3-1.jpg)

The absolute path to the private key is in `C:\Users\16264\.ssh\id_rsa.pub`

### The absolute path to the public key for your SSH key for logging into ieng6 (this is the one you copied to your account on ieng6, so it should be a path on ieng6's file system)

![image](./part3-2.jpg)

The absolute path to the public key is in `/home/linux/ieng6/oce/37/yal144/.ssh`.

### A terminal interaction where you log into ieng6 with your course-specific account without being asked for a password.

![image](./part3-3.jpg)

use `ssh-copy-id myemail@ieng6.ucsd.edu` copy to `C:\Users\16264\.ssh\known_hosts`.

# part 3
Using Linux for the first time, I knew nothing about commands, only cd, ls, pwd, etc. I also learned how to remote link: URLs and URIs. I also learned how to link remotely: URLs and URIs, which was very helpful, and I think this knowledge will help me in the future.
