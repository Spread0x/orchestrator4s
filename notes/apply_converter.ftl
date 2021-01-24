
<#macro args top><#list 1..top as idx>T${idx}<#sep>, </#list></#macro>
<#macro reference top><#list 1..top as idx>a._${idx}<#sep>, </#list></#macro>

<#list 1..22 as idx>

implicit def a${idx}[<@args idx/>]: ApplyConverter[(<@args idx/>), Task] {type In = (<@args idx/>) => Task} = new ApplyConverter[(<@args idx/>), Task] {

    type In = (<@args idx/>) => Task

    override def apply(in: In): ((<@args idx/>)) => Task = {
      a => in(<@reference idx/>)
    }
  }

</#list>