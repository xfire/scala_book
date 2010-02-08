object SymbolMain {

    def main(args: Array[String]) {

        def psym(s: Symbol) = println(s.name)

        psym('foo)
        psym('bar)

    }
}
