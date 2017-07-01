
import DaoImplementation.CategoryImpl;
import Dao.*;
import DaoImplementation.CustomerImpl;
import DaoImplementation.SaleImpl;
import Modelo.*;
import Negocio.CustomerBO;
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fernando
 */
public class test {
    public static void main(String[] args) {
        
//        SaleDao dao = new SaleImpl();
//        Sale sale = dao.findByState(1, "BUYING");
//        System.out.println(sale.getIdSale() + " "  + sale.getDateSale() + " " + sale.getState());
//        
        
//        Category cat= new Category(4,"cat4","ggggg");
//        CategoryImpl dx=new CategoryImpl();
//        dx.insert(cat);
        //cat=dx.find("dos");
        //System.out.println(cat.getIdCategory());
        /*ProductCategory pc=new ProductCategory(3,5);
        ProductCategoryDao pcdao=new ProductCategoryDao();
        pcdao.insert(pc);*/
        /*ArrayList<Category> it;
        it=dx.filter();
        for(Category xd:it)
        {
            System.out.println(xd.getName());
        }*/
        //Product prod=new Product();
       // ProductDao px=new ProductDao();
       // px.update(prod);
       /* prod.setIdProduct(8);
        prod.setName("producto8");
        prod.setDescription("ggg");
        prod.setPrice(12.2);
        prod.setStock(12);
        prod.setImage("url");
        px.insert(prod);*/
        //prod=px.find(1);
       // System.out.println(prod.getName());
        
        //px.delete(1);
        /*prod=px.find("producto2");
        System.out.println(prod.getIdProduct());*/
        /*ArrayList<Product> xd;
        xd=px.filterBySales();
        for(Product p:xd)
        {
            System.out.println(p.getIdProduct());
        }*/
        //Customer cus=new Customer("pepiato","****","dni","ruc","nombre","segundo","apellido","apellido2","direccion","email","11313","tipo");
        /*Customer cus=new Customer();
        cus.setIdCustomer(1);
        cus.setAddress("ggzote");
        cus.setEmail("fer@ads");
        cus.setPhoneNumber("no tengo");
        cus.setPassword("nueva**");
        CustomerDao daoc=new CustomerDao();
        daoc.update(cus);*/
        Sale sas=new Sale(200,20,"CONFIRMED",1);
        SaleDao desas= new SaleImpl();
        desas.insert(sas);
        sas=new Sale(180,20,"BUYING",1);
        desas.insert(sas);
        sas=new Sale(110,20,"PAID",1);
        desas.insert(sas);
       /* Sale sas2;
        sas2=desas.find(4);
        System.out.println(sas2.getTotalDiscount());*/
        //SaleDao desas=new SaleDao();
        //desas.delete(8);
        /*s.setIdSale(1);
        s.setState("pagado");
        s.setTotal(500);
        s.setTotalDiscount(4);
        SaleDao desas=new SaleDao();
        desas.update(s);*/
        /*ArrayList<Sale> xd;
        xd=desas.filter(1);
        for(Sale p:xd)
        {
            System.out.println(p.getIdSale());
        }*/
        /*SaleDetail sd=new SaleDetail();
        SaleDetailDao sdo= new SaleDetailDao();*/
        //sdo.insert(sd);
        /*sd=sdo.find(2,1);
        System.out.println(sd.getQuantity());*/
        /*ArrayList<SaleDetail> xd;
        xd=sdo.filter(1);
        for(SaleDetail p:xd)
        {
            System.out.println(p.getQuantity());
        }*/
        /*sd.setDiscount(12);
        sd.setQuantity(8);
        sd.setSubtotal(40);
        sd.setIdProduct(1);
        sd.setIdSale(1);
        sdo.update(sd);*/
        //sdo.delete(2, 1);
        
    }
}
