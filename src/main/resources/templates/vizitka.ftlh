[#ftl]
[@c.page]
    <div class="detail">

        <form class="row g-3" action="/smazat" method="post">
            <button type="submit" class="btn btn-primary">Smazat</button>
            <input type="hidden" name="id" class="form-control" id="web" value="${id}">
        </form>

        <div class="vizitka">

            <div class="jmeno">${vizitka.celeJmeno}</div>
            <div class="firma">${vizitka.firma}</div>

        <div class="udaje">
        <div class="adresa">
            <div>${vizitka.ulice}</div>
            <div>${vizitka.psc} ${vizitka.obec}</div>
       </div>

        <div class="kontakty">
        <div>
             [#if vizitka.email?has_content]
                 <i class="las la-at"></i><span>${vizitka.email}</span>
             [/#if]
         </div>
         <div>
             [#if vizitka.telefon?has_content]
                 <i class="las la-phone-alt"></i><span>${vizitka.telefon}</span>
             [/#if]
         </div>
         <div>
             [#if vizitka.web?has_content]
                 <i class="las la-globe"></i><span>${vizitka.web}</span>
             [/#if]
         </div>
         </div>
        </div>

        <div class="mapa">
            <iframe style="border:none" src="https://frame.mapy.cz/?q=${vizitka.celaAdresa?url}" width="100%" height="100%" frameborder="0"></iframe>
        </div>

        [@c.back /]
    </div>
[/@c.page]
