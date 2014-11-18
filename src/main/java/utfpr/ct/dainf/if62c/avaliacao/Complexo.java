package utfpr.ct.dainf.if62c.avaliacao;

/**
 * UTFPR - Universidade Tecnológica Federal do Paraná
 * DAINF - Departamento Acadêmico de Informática
 * IF62C - Fundamentos de Programação 2
 * 
 * Primeira avaliação parcial 2014/2.
 * @author 
 */
public class Complexo {
    private double real;
    private double img;

    public Complexo() {
    }

    public Complexo(double real, double img) {
        this.real = real;
        this.img = img;
    }

    public double getReal(){
        return real;
    }

    public double getImg(){
        return img;
    }
    
    public Complexo soma(Complexo c) {
        return new Complexo(real + c.real, img + c.img);
    }
    
   public Complexo sub(Complexo c){
       return new Complexo(real - c.real, img - c.img);
   }

   public Complexo prod(double d){
       return new Complexo(real*d, img*d);
   }

   // implementar prod(Complexo)
   public Complexo prod(Complexo c){
       return new Complexo(real*c.real - img*c.img, real*c.img + img*c.real);
   }
    
    // implementar div(Complexo)
   public Complexo div(Complexo c){
       return new Complexo((real*c.real + img*c.img)/(Math.pow(c.real, 2)+Math.pow(c.img, 2)), 
               (c.real*img - real*c.img)/(Math.pow(c.real, 2)+Math.pow(c.img, 2)));
   }
   
    // implementar sqrt()
    public Complexo[] sqrt() {
        Complexo[] sqr = new Complexo[2];
        double r, ro;
        double auxr,auxi;
        
        r = Math.sqrt(Math.pow(real,2)+Math.pow(img,2));
        ro= calcRo(real, img);
        auxr = Math.sqrt(r)*Math.cos(ro);
        auxi = Math.sqrt(r)*Math.sin(ro);
        sqr[0] = new Complexo(auxr, auxi);
        auxr = Math.sqrt(r)*Math.cos(ro+Math.PI);
        auxi = Math.sqrt(r)*Math.sin(ro+Math.PI);        
        sqr[1] = new Complexo(auxr, auxi);
        
        return sqr;
    }

    private double calcRo(double real, double img){
        double ro;
        if(real==0){
            if(img==0){
                return 0;
            }else if(img>0){
                return Math.PI/2;
            }else if(img<0){
                return 3*Math.PI/2;
            }
        }
        if(real>0)
            return Math.atan(img/real);
        else
            return Math.atan(img/real)+Math.PI;
        
    }
        
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + (int) (Double.doubleToLongBits(real)
            ^ (Double.doubleToLongBits(real) >>> 32));
        hash = 41 * hash + (int) (Double.doubleToLongBits(img)
            ^ (Double.doubleToLongBits(img) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        final Complexo c = (Complexo) obj;
        return obj != null && getClass() == obj.getClass()
            && real == c.real && img == c.img;
    }

    @Override
    public String toString() {
        return String.format("%+f%+fi", real, img);
    }
}
