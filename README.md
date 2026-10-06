# КТ №5 Алгоритмы


## Требования

- JDK 21
- Maven 3.9+

## Тесты

Запуск всех тестов:

```bash
mvn test
```

## Сборка

```bash
mvn package
```

После сборки классы находятся в `target/classes`.

## Задача 1. Правильные скобочные последовательности

Класс:

```text
com.example.kt5.Task1Parentheses
```

Запуск:

```bash
java -cp target/classes com.example.kt5.Task1Parentheses
```

Пример:

```text
Ввод:
3

Вывод:
((()))
(()())
(())()
()(())
()()()
```

## Задача 2. Динамический словарь и количество слов по префиксу

Класс:

```text
com.example.kt5.Task2PrefixDictionary
```

Поддерживаются операции:

```text
ADD word
REMOVE word
COUNT prefix
```

Запуск:

```bash
java -cp target/classes com.example.kt5.Task2PrefixDictionary
```

Используется trie со счётчиком количества активных слов в каждом поддереве

Время одной операции пропорционально длине строки

## Задача 3. Два числа, встречающиеся один раз

Класс:

```text
com.example.kt5.Task3TwoUnique
```

Запуск:

```bash
java -cp target/classes com.example.kt5.Task3TwoUnique
```

Пример:

```text
Ввод:
6
1 2 1 3 2 5

Вывод:
3 5
```

Используются XOR и разделяющий бит.

Сложность:

```text
Время: O(n)
Дополнительная память: O(1)
```

## Задача 4. Ферзи с запрещёнными клетками

Класс:

```text
com.example.kt5.Task4BlockedQueens
```

В первой строке вводятся `n` и количество запрещённых клеток. Затем задаются пары `row column`

Запуск:

```bash
java -cp target/classes com.example.kt5.Task4BlockedQueens
```
## Задача 5. K-е слово по префиксу

Класс:

```text
com.example.kt5.Task5KthWord
```

Поддерживаются операции:

```text
ADD word
REMOVE word
KTH prefix k
```

Запуск:

```bash
java -cp target/classes com.example.kt5.Task5KthWord
```


Если подходящих слов меньше `k`, выводится:

```text
NONE
```

## Задача 6. Максимальный XOR непрерывного фрагмента

Класс:

```text
com.example.kt5.Task6MaxSubarrayXor
```

Запуск:

```bash
java -cp target/classes com.example.kt5.Task6MaxSubarrayXor
```

Используются префиксные XOR и бинарный trie.

Сложность:

```text
Время: O(30 * n)
Память: O(30 * n)
```

## Структура

```text
src/main/java/com/example/kt5
├── DynamicWordTrie.java
├── FastScanner.java
├── Task1Parentheses.java
├── Task2PrefixDictionary.java
├── Task3TwoUnique.java
├── Task4BlockedQueens.java
├── Task5KthWord.java
└── Task6MaxSubarrayXor.java

src/test/java/com/example/kt5
└── AlgorithmsTest.java
```
