/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nodos;

import Atributos.Company;
import Atributos.Direccion;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Se crea el objeto Usuario al cual se le atribuye la información extraída del JSON.
 */
public class Usuario extends Nodo{
    
    int id;
    String name;
    String username;
    String email;
    String phone;
    String website;
    Company company;
    Direccion direccion;
    Usuario link;
    Publicacion postPtr;
    Publicacion lastPost;
    Usuario userPtr;
    
    public Usuario() {
    }
    /**
     * Se recibe la información extraída del JSON para el usuario.
     * @param id
     * @param name
     * @param username
     * @param email
     * @param street
     * @param suite
     * @param city
     * @param zipcode
     * @param lat
     * @param lng
     * @param phone
     * @param website
     * @param nameC
     * @param catchPhrase
     * @param bs
     * @param link 
     */
    public Usuario(int id, String name, String username, String email, 
                   String street, String suite,String city, String zipcode,
                   String lat, String lng, String phone, String website ,
                   String nameC, String catchPhrase, String bs,Usuario link) {
        
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.website = website;
        this.link=link;
        company = new Company();
        company.setName(nameC);
        company.setCatchPhrase(catchPhrase);
        company.setBs(bs);
        direccion = new Direccion(street, suite, city, zipcode, lat, lng);
        
    }
    /**
     * Se sobre escribe el método toString, para escribir la información del usuario.
     * @return 
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Id: "+id+"\n");
        sb.append("Nombre: "+name+"\n");
        sb.append("username: "+username+"\n");
        sb.append("email: "+email+"\n");
        sb.append(company.toString());
        sb.append("phone: "+phone+"\n");
        sb.append("website: "+website+"\n");
        sb.append(direccion.toString());
        
        return sb.toString();
    }
    /**
     * Fase de prueba para buscar al usuario con sus posts y respectivos comentarios
     * 
     */
    /*
    StringBuilder sbp = new StringBuilder();
    
    public String publicacionesUsuario(Usuario u,String username){
        Usuario p = u;
        while (u.getUsername()!= username) {
            p = u.link;
        }
        sbp.append("Post:\n");
        sbp.append("    Title:\n"+p.getPostPtr().title);
        sbp.append("    Body:\n"+p.getPostPtr().getBody());
        sbp.append("Comments:\n");
        sbp.append("    User:\n"+p.getPostPtr().getComentarioPtr().getName());
        sbp.append("    Body:\n"+p.getPostPtr().getComentarioPtr().getBody());
        
        return sbp.toString();
    }
    */
    public void addPost(Publicacion p){
        Publicacion ptr = postPtr;
        while(ptr.link!=null){
            ptr=ptr.link;
        }
        ptr.link = p;
    }
    /**
     * Getters y setters.
     * @return 
     */
    public Publicacion getLastPost() {
        return lastPost;
    }

    public void setLastPost(Publicacion lastPost) {
        this.lastPost = lastPost;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public void createAddress() {
            this.direccion = new Direccion();
        
    }

    public void createCompany() {
            company = new Company();
        
    }

    public Usuario getLink() {
        return link;
    }

    public void setLink(Usuario link) {
        this.link = link;
    }

    public Publicacion getPostPtr() {
        return postPtr;
    }

    public void setPostPtr(Publicacion postPtr) {
        this.postPtr = postPtr;
    }

    Publicacion havePost(Publicacion ptr, int postID) {
        if(ptr == null){
            return null;
        }else if(ptr.id==postID){
            return ptr;
        }else{
            return havePost(ptr.link, postID);
        }
    }
    
    public int postSize(){
        Publicacion p = this.postPtr;
        int count=0;
        while(p!=null){
            count++;
            p=p.link;
        }
        return count;
    }
    
    public int totalPostSize() {
        int c = 0;
        Usuario u = userPtr;
        while (u != null) {
            c += u.postSize();
            u = u.link;
        }
        return c;
    }
    
    public int totalCommentSize() {
    Publicacion p = this.postPtr;
        int count = 0;
        while(p!=null){
            count += p.commentsSize();
            p=p.link;
        }
        return count;
    }
    

    
}
