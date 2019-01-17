package rest;

import dao.TestObj;
import org.apache.log4j.Logger;

import javax.ejb.Stateless;
import javax.ws.rs.*;

import static rest.api.IRestApiMediaType.JSON_UTF8;
import static rest.api.IRestApiMediaType.TEXT_UTF8;

@Path("/")
@Stateless
public class HelloRest {
    TestObj testObj;
    private static final Logger log = Logger.getLogger(HelloRest.class);
    /**
     * http://localhost:8080/rest/hello
     */
    @GET
    @Path("/hello")
    @Produces(TEXT_UTF8)
    public String hello() {
        return "Hellolo!";
    }

    @GET
    @Path("/testo")
    @Produces(JSON_UTF8)
    public TestObj getTestObj(){
       if (testObj == null) testObj = new TestObj(1, "ыыыыы", true);
       return testObj;
    }

    @POST
    @Consumes(JSON_UTF8)
    public void setTestObj(TestObj testObj){
       log.info("testObj = " + testObj.getS());
    }

//    @GET
//    @Path("/users")
//    public Response getAllUser(){
//        try{
//            Query quUsers = em.createQuery("select u from User u", User.class);
//            List<User> users = quUsers.getResultList();
//            return Response.ok(users.get(0).getName()).build();
//        }catch(Exception e){
//            throw new WebApplicationException(Response.status(404).type("text/plain")
//                                                      .entity(MessageFormat.format("select u from User u -> {0}", e.getStackTrace()))
//                                                      .build());
//        }
//     }
}
