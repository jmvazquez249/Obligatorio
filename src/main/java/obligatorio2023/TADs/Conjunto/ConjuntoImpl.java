package obligatorio2023.TADs.Conjunto;


import obligatorio2023.Exception.IllegalIndexException;
import obligatorio2023.TADs.MyLinkedList.MyLinkedListImp;
import obligatorio2023.TADs.MyLinkedList.Node;

public class ConjuntoImpl<T>  extends MyLinkedListImp<T> implements Conjunto<T>
    {
        @Override
        public ConjuntoImpl<T> union(ConjuntoImpl<T> otroConjunto) {
             ConjuntoImpl<T> conjnuevo= new ConjuntoImpl<>();
             for(int i=0;i< otroConjunto.largo();i++){
                 conjnuevo.agregar(otroConjunto.elemento(i));
             }
             ConjuntoImpl<T> diferencia= new ConjuntoImpl<>();
             diferencia=this.diferencia(otroConjunto);
             for(int k=0; k< diferencia.largo();k++){
                 conjnuevo.agregar(diferencia.elemento(k));
             }
             return conjnuevo;
        }

        @Override
        public Node<T> getPrimero() {
            return super.getPrimero();
        }

        @Override
        public boolean esVacia() {
            return super.esVacia();
        }

        @Override
        public void agregar(T obj) {
            super.agregar(obj);
        }

        @Override
        public void agregarAlFinal(T obj) {
            super.agregarAlFinal(obj);
        }

        @Override
        public void agregar(T obj, int index) throws IllegalIndexException {
            super.agregar(obj, index);
        }

        @Override
        public int largo() {
            return super.largo();
        }

        @Override
        public T quitar(int index) {
            return super.quitar(index);
        }

        @Override
        public T elemento(int index) {
            return super.elemento(index);
        }

        @Override
        public void vaciar() {
            super.vaciar();
        }

        @Override
        public void imprimirDatos() {
            super.imprimirDatos();
        }

        @Override
        public ConjuntoImpl<T> interseccion(ConjuntoImpl<T> otroConjunto) {
            ConjuntoImpl<T> conjaux= new ConjuntoImpl<>();
            for(int i=0;i<this.largo();i++){
                for(int k=0;k< otroConjunto.largo();k++){
                    if(this.elemento(i) == otroConjunto.elemento(k)){
                        conjaux.agregar(this.elemento(i));
                        k= otroConjunto.largo();

                    }

                }
            }
            return conjaux;
        }

        @Override
        public ConjuntoImpl<T> diferencia(ConjuntoImpl<T> otroConjunto) {
            ConjuntoImpl<T> conjaux= new ConjuntoImpl<>();
            for(int i=0;i<this.largo();i++){
                {int k=0;
                    while(this.elemento(i) != otroConjunto.elemento(k) && k< otroConjunto.largo()){
                        k++;
                    }
                    if(k == otroConjunto.largo()){
                        conjaux.agregar(this.elemento(i));
                    }

                }
            }

            return conjaux;
        }

        @Override
        public ConjuntoImpl<T> diferenciaSimetrica(ConjuntoImpl<T> otroConjunto) {
            return this.diferencia(otroConjunto).union(otroConjunto.diferencia(this));
        }
        //IMPLEMENTACION DE LOS METODOS
            }
