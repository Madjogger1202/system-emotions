require: slotfilling/slotFilling.sc
  module = sys.zb-common

init:
    bind("postProcess", function($context) {
        log(toPrettyString($context.nBest));
    });
theme: /

    state: Start
        q!: $regex</start>
        a: Начнём.

    state: Hello
        intent!: /привет
        a: Привет привет

    state: Bye
        intent!: /пока
        a: Пока пока
    
    state: Intent
        intent!: /интент
        a: Сработал интент.

    state: NoMatch
        event!: noMatch
        a: Я не понял. Вы сказали: {{$request.query}}

    state: Match
        event!: match
        a: {{$context.intent.answer}}