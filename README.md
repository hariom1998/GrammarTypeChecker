# CHOMSKY Grammar Type-Checker JAVA Program

According to Noam Chomosky, there are four types of grammars − Type 0, Type 1, Type 2, and Type 3.

Type 3 - Regular Languages
As we have discussed, a regular language is one which can be represented by a regular grammar, described using a regular expression, or accepted using an NFA or a DFA.

Type 2 - Context-Free Languages
A Context-Free Grammar (CFG) is one whose production rules are of the form: The productions must be in the form A → γ where A ∈ N (Non terminal) and γ ∈ (T ∪ N)* (String of terminals and non-terminals).

Type 1 - Context-sensitive grammar
The productions must be in the form α A β → α γ β where A ∈ N (Non-terminal) and α, β, γ ∈ (T ∪ N)* (Strings of terminals and non-terminals) The strings α and β may be empty, but γ must be non-empty. The rule S → ε is allowed if S does not appear on the right side of any rule. The languages generated by these grammars are recognized by a linear bounded automaton.

Type 0 - Unrestricted grammar
The productions have no restrictions. They are any phase structure grammar including all formal grammars. They generate the languages that are recognized by a Turing machine. The productions can be in the form of α → β where α is a string of terminals and nonterminals with at least one non-terminal and α cannot be null. β is a string of terminals and non-terminals.
