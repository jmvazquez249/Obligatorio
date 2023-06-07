package obligatorio2023.TADs.Conjunto;

public interface Conjunto<T>{

    ConjuntoImpl<T> union(ConjuntoImpl<T> otroConjunto);
    ConjuntoImpl<T> interseccion(ConjuntoImpl<T> otroConjunto);
    ConjuntoImpl<T> diferencia(ConjuntoImpl<T> otroConjunto);
    ConjuntoImpl<T> diferenciaSimetrica(ConjuntoImpl<T> otroConjunto);
}
