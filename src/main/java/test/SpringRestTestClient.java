package test;

import com.springmvc.pojo.People;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;

public class SpringRestTestClient {
    public static final String REST_SERVICE_URI = "http://localhost:8011/testRestful";

    /**
     *
     */
    @SuppressWarnings("unchecked")
    private static void listAllUsers(){
        System.out.println("testing listAllUsers api---");
        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String,Object>> usersMap = restTemplate.getForObject(
                REST_SERVICE_URI+"/user",List.class
        );
        if(usersMap!=null){
            for(LinkedHashMap<String, Object> map : usersMap){
                System.out.println("User : id="+map.get("id")+
                        ", username="+map.get("username")+
                        ", address="+map.get("address")+
                        ", email="+map.get("email"));;
            }
        }else{
            System.out.println("No user exist----------");
        }
    }

    /* GET */
    private static void getUser(){
        System.out.println("Testing getUser API----------");
        RestTemplate restTemplate = new RestTemplate();
        People user = restTemplate.getForObject(REST_SERVICE_URI+"/user/1", People.class);
        System.out.println(user);
    }

    /**
     * post
     * @param
     */
    private static void createUser(){
        System.out.println("testing create User api");
        RestTemplate restTemplate = new RestTemplate();
        People user = new People();
        user.setAddress("深圳");
        user.setEmail("1@126.com");
        user.setUsername("懒懒");
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"/user",user,People.class);
        System.out.println("location:"+uri.toASCIIString());
    }

    /**
     * put
     */
    private static void updateUser(){
        System.out.println("testing update user api---------");
        RestTemplate restTemplate = new RestTemplate();
        People user = new People();
        user.setId(1);
        user.setUsername("chenbin");
        user.setAddress("peking");
        user.setEmail("13790432378@163.com");
        restTemplate.put(REST_SERVICE_URI+"/user/1",user);
        System.out.println(user);
    }

    /**
     * delete
     */
    private static void deleteUser(){
        System.out.println("testing all delete user api------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+"/user/3");
    }

    /**
     * deleteAll
     */
    private static void deleteAllUsers(){
        System.out.println("testing all delete user api------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+"/user");
    }

    public static void main(String args[]){
        listAllUsers();
        //getUser();
        //createUser();
        listAllUsers();
        //updateUser();
        listAllUsers();
        //deleteUser();
        listAllUsers();
        //deleteAllUsers();
        listAllUsers();
    }
}
