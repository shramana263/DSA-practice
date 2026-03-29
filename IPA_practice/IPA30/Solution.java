import java.util.Arrays;
import java.util.Scanner;
class Document{
    private int id,pages;
    private String title, folder;

    public Document(int id, String title, String folder, int pages){
        this.id=id;
        this.title=title;
        this.folder=folder;
        this.pages=pages;
    }
    public int getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public String getFolder(){
        return folder;
    }
    public int getPages(){
        return pages;
    }

}

public class Solution {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        Document[] doc= new Document[4];
        for(int i=0;i<4;i++){
            int a= sc.nextInt();sc.nextLine();
            String b= sc.nextLine();
            String c= sc.nextLine();
            int d= sc.nextInt();sc.nextLine();

            doc[i]= new Document(a,b,c,d);
        }
        Document[] obj= docsWithOddPages(doc);
        if(obj==null){
            System.out.println("404 not found");
        }
        else{
            for(Document o:obj){
                System.out.println(o.getId()+" "+o.getTitle()+" "+o.getFolder()+" "+o.getPages());
            }
        }
        sc.close();
    }
    public static Document[] docsWithOddPages(Document[] docs){
        Document[] obj= new Document[0];
        for(Document d:docs){
            if(d.getPages()%2!=0){
                obj=Arrays.copyOf(obj,obj.length+1);
                obj[obj.length-1]=d;
            }
        }
        if(obj.length<1){
            return null;
        }
        Document temp;
        for(int i=0;i<obj.length-1;i++){
            for(int j=i+1;j<obj.length;j++){
                if(obj[i].getId()>obj[i+1].getId()){
                    temp=obj[i];
                    obj[i]=obj[i+1];
                    obj[i+1]=temp;
                }
            }
        }
        return obj;
    }
}
