package com.example.pushyapp.Models.GameElements;

/**
 * Interface, das Elementen die Fähigkeit gibt, mit anderen Elementen interagieren zu können.
 * @author Simon Schnitker
 */
public interface Interactable
{
    /**
     * Versucht, das zugrundeliegende Element mit dem übergebebenen Element interagieren zu lassen.
     * @param element Das Element, mit dem interagiert werden soll.
     * @return Gibt zurück, ob die Interaktion erfolgreich war.
     * @author Simon Schnitker
     */
    boolean tryInteract(GameElement element);
}