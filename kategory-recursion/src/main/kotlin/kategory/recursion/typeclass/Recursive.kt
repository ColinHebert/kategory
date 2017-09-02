package kategory

interface Recursive<F, G> : Typeclass {
    fun projectT(fg: HK<F, G>): HK<ComposedType<F, G>, HK<F, G>>

    fun <A> cata(t: HK<F, G>, f: Algebra<ComposedType<F, G>, A>, FF: Functor<F>, FG: Functor<G>): A =
            hylo(t, f, this::projectT, ComposedFunctor(FF, FG))
}