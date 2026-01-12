// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel {
    BASICO, INTERMEDIARIO, DIFICIL
}

class Usuario(val nome: String)

data class ConteudoEducacional(
    var nome: String,
    val duracao: Int = 60,
    val nivel: Nivel = Nivel.BASICO
)

data class Formacao(
    val nome: String,
    var conteudos: List<ConteudoEducacional>
) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        if (!inscritos.contains(usuario)) {
            inscritos.add(usuario)
            println("Usuário ${usuario.nome} matriculado na formação $nome.")
        } else {
            println("Usuário ${usuario.nome} já está matriculado na formação $nome.")
        }
    }
}

fun main() {
    // Criando conteúdos educacionais
    val kotlinBasico = ConteudoEducacional(
        nome = "Kotlin Básico",
        duracao = 90,
        nivel = Nivel.BASICO
    )

    val kotlinPOO = ConteudoEducacional(
        nome = "Kotlin POO",
        duracao = 120,
        nivel = Nivel.INTERMEDIARIO
    )

    val kotlinAvancado = ConteudoEducacional(
        nome = "Kotlin Avançado",
        duracao = 150,
        nivel = Nivel.DIFICIL
    )

    // Criando uma formação
    val formacaoKotlin = Formacao(
        nome = "Formação Kotlin Developer",
        conteudos = listOf(kotlinBasico, kotlinPOO, kotlinAvancado)
    )

    // Criando usuários
    val usuario1 = Usuario("Ronald")
    val usuario2 = Usuario("Ana")

    // Simulando matrículas
    formacaoKotlin.matricular(usuario1)
    formacaoKotlin.matricular(usuario2)
    formacaoKotlin.matricular(usuario1) // tentativa de matrícula duplicada

    // Exibindo dados finais
    println("\nFormação: ${formacaoKotlin.nome}")
    println("Conteúdos:")
    formacaoKotlin.conteudos.forEach {
        println("- ${it.nome} (${it.nivel}, ${it.duracao} min)")
    }

    println("\nUsuários matriculados:")
    formacaoKotlin.inscritos.forEach {
        println("- ${it.nome}")
    }
}
