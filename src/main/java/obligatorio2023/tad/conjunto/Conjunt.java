package obligatorio2023.tad.conjunto;

public interface Conjunt <T>{
    /*
 Union de conjuntos
Ejemplo de operaciones con conjuntos
this={2,4,5,6}, otroConjunto={2,3,5} entonces devuelve un conjunto nuevo = {2,3,4,5,6}
*/
    public Conjunto<T> union(Conjunto<T> otroConjunto);
    /*Intersección: this={2,4,5,6}, otroConjunto={2,3,5} entonces devuelve un conjunto nuevo = {2,5}*/
    public Conjunto<T> interseccion(Conjunto<T> otroConjunto);
    /*Diferencia: this={2,4,5,6}, otroConjunto={2,3,5} entonces devuelve un conjunto nuevo = {4,6}*/
    public Conjunto<T> diferencia(Conjunto<T> otroConjunto);
    /*Intersección: this={2,4,5,6}, otroConjunto={2,3,5} entonces devuelve un conjunto nuevo = {4,6,3}*/
    public Conjunto<T> diferenciaSimetrica(Conjunto<T> otroConjunto);
}
