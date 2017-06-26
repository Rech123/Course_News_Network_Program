/**
 * Created by rashed on 5/5/2017.
 */
public interface IObsevable {
    public void add(Ioberver s);
    public void remover(Ioberver ioberver);
    public void Notify();
}
