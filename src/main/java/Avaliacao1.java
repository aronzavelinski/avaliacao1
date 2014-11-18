/**
 * UTFPR - Universidade Tecnológica Federal do Paraná
 * DAINF - Departamento Acadêmico de Informática
 * IF62C - Fundamentos de Programação 2
 * 
 * Primeira avaliação parcial 2014/2.
 * @author 
*/
import utfpr.ct.dainf.if62c.avaliacao.Complexo;

public class Avaliacao1 {

    public static void main(String[] args) {
        Complexo a1 = new Complexo(1,0);
        Complexo b1 = new Complexo(5,0);
        Complexo c1 = new Complexo(4,0);
        
        Complexo a2 = new Complexo(1,0);
        Complexo b2 = new Complexo(2,0);
        Complexo c2 = new Complexo(5,0);
        
        Complexo[] x = raizesEquacao(a1,b1,c1);
        
        Complexo[] y = raizesEquacao(a2,b2,c2);
        System.out.println("x1="+x[0].toString());
        System.out.println("x2="+x[1].toString());
        System.out.println("y1="+y[0].toString());
        System.out.println("y2="+y[1].toString());
    }
    
    public static Complexo[] raizesEquacao(Complexo a, Complexo b, Complexo c){
        Complexo aux = a.prod(c);
        aux= aux.prod(4);
        Complexo aux2 = b.prod(b);
        aux2 = aux2.sub(aux);
        Complexo[] resp = aux2.sqrt();
        
        resp[0] = resp[0].soma(b.prod(-1));
        resp[1] = resp[1].soma(b.prod(-1));
        resp[0] = resp[0].div(a.prod(2));
        resp[1] = resp[1].div(a.prod(2));
        
        return resp;
    }
    
}
