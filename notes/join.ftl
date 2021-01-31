
<#macro args top><#list 1..top as idx>T${idx}<#sep>, </#list></#macro>
<#macro argsp top><#list 1..(top-1) as idx>T${idx}<#sep>, </#list></#macro>
<#macro reference top><#list 1..(top-1) as idx>a._${idx}<#sep>, </#list></#macro>

<#list 3..22 as idx>

implicit def j${idx}[<@args idx/>]: Join[(<@argsp idx/>), Tuple1[T${idx}]] {type OUT = (<@args idx/>)} = new Join[(<@argsp idx/>), Tuple1[T${idx}]] {
    type OUT = (<@args idx/>)

    override def apply(a: (<@argsp idx/>), b: Tuple1[T${idx}]): OUT = (<@reference idx/>, b._1)
}

</#list>



<#---->


<#macro args top><#list 1..top as idx>T${idx}<#sep>, </#list></#macro>
<#macro argsp top><#list 1..(top-1) as idx>T${idx}<#sep>, </#list></#macro>
<#macro reference top><#list 1..(top-1) as idx>a._${idx}<#sep>, </#list></#macro>

<#list 3..22 as idx>

    implicit def j${idx}[<@args idx/>]: Join[(<@argsp idx/>), T${idx}] {type OUT = (<@args idx/>)} = new Join[(<@argsp idx/>), T${idx}] {
    type OUT = (<@args idx/>)

    override def apply(a: (<@argsp idx/>), b: T${idx}): OUT = (<@reference idx/>, b._1)
    }

</#list>
