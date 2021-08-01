/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Categoria;

public interface ImplementarCrudCat {
    public void Create(Categoria cat);
    public Categoria Read(int codcat);
    public void Update (Categoria cat);
    public void Delete(int codcat);
    
}
