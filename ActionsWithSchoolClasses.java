package School;

interface ActionsWithSchoolClas {

    //Сортировка школьного класса по средней оценке
    void sortedByAverageRating ();
    //Возвращает массив школьников количеством col с конца списка
    Schoolboy[] getTheLast(int col);
    //Удалляет из списка школьников количеством col с конца списка
    void removeTheLast(int col);
    //Удалляет из списка школьников
    void remove ();

}
