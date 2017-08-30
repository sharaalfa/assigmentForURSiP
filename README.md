# assigmentForURSiP
Создать запрос, который возвратит данные представленные в следующей таблице: 
Используя БД из файла "Задача по БД.doc" создать приложение, которое

1) Имеет форму ввода с комбобоксом, в котором отображаются данные из таблицы Types и кнопку “Поиск”

2) По нажатию на кнопку “Поиск” приложение должно найти статьи выбранного типа, подсчитать кол-во официальных и английских текстов, связанных с ними (т.е. полностью идентичное задание как в файле "Задача по БД.doc") и вывести их на экран в виде таблицы.

3) Приложение должно быть написано на Spring Framework. На дизайн время не тратить. 
Решение задания по бд:
SELECT Article_Name, Count_Official_Text, Count_English_Text FROM
  (SELECT Article_Name, CASE
WHEN dd NOTNULL THEN dd ELSE 0 END  AS Count_Official_Text FROM
  (SELECT name AS Article_Name FROM articles WHERE typeid=1) AS d1
LEFT JOIN
  (SELECT Article_N,  count(text) AS dd FROM
  (SELECT id AS art, name AS Article_N FROM articles WHERE typeid=1) as a,
  (SELECT id AS offic, name AS text FROM articles WHERE typeid=4) as b,
  article_link WHERE art=article1_id AND offic=article2_id GROUP BY Article_N) AS d2
  ON Article_Name=Article_N) d3
LEFT JOIN
  (SELECT Article_Name1, CASE
WHEN dd NOTNULL THEN dd ELSE 0 END  AS Count_English_Text FROM
  (SELECT name AS Article_Name1 FROM articles WHERE typeid=1) AS d1
LEFT JOIN
  (SELECT Article_N,  count(text) AS dd FROM
  (SELECT id AS art, name AS Article_N FROM articles WHERE typeid=1) as a,
  (SELECT id AS offic, name AS text FROM articles WHERE typeid=5) as b,
  article_link WHERE art=article1_id AND offic=article2_id GROUP BY Article_N) AS d2
  ON Article_Name1=Article_N) d4
  ON Article_Name=Article_Name1;
