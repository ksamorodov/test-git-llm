require: slotfilling/slotFilling.sc
  module = sys.zb-common
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

    state: NoMatch
        event!: noMatch
        a: Я не понял. Вы сказали: {{$request.query}}

    state: Match
        event!: match
        a: {{$context.intent.answer}}

    state: NewState
        AIAgent: 
            id = translator_agent
            model = gpt-oss-120
            temperature = 0.6
            topP = 1
            frequencyPenalty = 0
            presencePenalty = 0
            maxTokens = 4000
            role = Профессиональный переводчик
            goal = Переведи текст, который отправит тебе пользователь
            instructions = Узнай, на какой язык перевести текст. Предложи три варианта перевода. Уточни, нравится ли пользователю перевод. Если нужно, сгенерируй новые варианты
            requiredData = 
            context = 
            functions = [""]
            llmClassificationEnabled = false
            intentConfidence = 
            chatHistoryEnabled = false
            chatHistoryLimit = 50
            knowledgeBase = 
            knowledgeBaseConfidence = 0.8