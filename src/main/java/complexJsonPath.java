import files.Payload;
import io.restassured.path.json.JsonPath;

public class complexJsonPath {

     public static void main(String[] args) {
         JsonPath js = new JsonPath(Payload.CoursePrice());
         int courses = js.getInt("courses.size()");
         //String  courses = js.getString("courses");
         System.out.println(courses);
         int purchaseAmount=js.getInt("dashboard.purchaseAmount");
         System.out.println(purchaseAmount);
         //String title = js.getString("courses[0].title");
         //System.out.println(title);



         int total_amount=0;
         for (int i=0;i<courses;i++){
                int copies = js.getInt("courses[" + i + "].copies");
                int price_copy = js.getInt("courses["+i+"].price");
                int priceTotal = copies*price_copy;
                total_amount += priceTotal;
                System.out.println(total_amount);


             }

         }
     }

