package de.hft_stuttgart.ip1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static de.hft_stuttgart.ip1.TestHelpers.measureRuntime;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(de.hft_stuttgart.ip1.TestResultLoggerExtension.class)
class VolltextTest {
    String shortPlain = "Im Bewusstsein seiner Verantwortung vor Gott und den Menschen " +
            "von dem Willen beseelt, seine nationale und staatliche Einheit zu" +
            " wahren und als gleichberechtigtes Glied in einem vereinten Europa" +
            " dem Frieden der Welt zu dienen, hat das Deutsche Volk in den Ländern" +
            " Baden, Bayern, Bremen, Hamburg, Hessen, Niedersachsen, Nordrhein-Westfalen," +
            " Rheinland-Pfalz, Schleswig-Holstein, Württemberg-Baden und Württemberg-Hohenzollern, " +
            "um dem staatlichen Leben für eine Übergangszeit eine neue Ordnung zu geben, kraft" +
            " seiner verfassungsgebenden Gewalt dieses Grundgesetz der Bundesrepublik Deutschland" +
            " beschlossen. Es hat auch für jene Deutschen gehandelt, denen mitzuwirken versagt" +
            " war. Das gesamte Deutsche Volk bleibt aufgefordert, in freier Selbstbestimmung" +
            " die Einheit und Freiheit Deutschlands zu vollenden.";
    String shortCode = "n,m,r.esektee.ndmnsrs,,nnn,,e,,rreerm,ddttdnktanmnd,znguttrnnnhunsss,kd,r," +
            "nee,ntdm,tnntemrnunguttgstennngnnnzntntntngggdnrnn-                       --￭      -" +
            "       -   pttsBBrswnf wfHsllhlgrwdDfhhnaa  BeeehmmÜ  t ulimuiississssSsaennnnnenn n" +
            "   n  eaan   nernn   rrntnihuhhnnlnLggriiisggllrrsths   sshrhzhhSWdedddnttrtdhddldbh" +
            "ndrkhdmsslnbsdbljdiMhrdindnVbvvbbbdyldvdtsgbbigdHWblsnDDDDDGBtPrue a  nnnrrrir sf  d" +
            " nnaice  ccccrRinncccoccccacceelldlrNdedwtelWt   eeeeeeeeeEEeetweeeem illr hnheabgla" +
            "llhttGbooioohaoaeeeaIeeueeeeae iamreeeeeeoieiieeeieeeeereeeeieerieeo uuuauuaaeeäuuae" +
            "iiiieeii uuuuaiiieiadeHVVvzHvirvfNwlGoeeoeeeüüeakeoOoefFeBhseueeedFieeeueeeüüoGaeeal" +
            "Edrretttntteet   shseegeeoua  bleessegiabalifitglilrlsssmsttngshsaaauuuuusorrrneizzz" +
            "zpaea      BrmtnsbEweeeeez       e suteatlsn    t LffWW.";

    String longPlain = "*****  VERORDNUNG (EWG) Nr. 1677/88 DER KOMMISSION  vom 15. " +
            "Juni 1988  zur Festsetzung von Qualitätsnormen für Gurken  D" +
            "IE KOMMISSION DER EUROPÄISCHEN  GEMEINSCHAFTEN -  gestützt a" +
            "uf den Vertrag zur Gründung der Europäischen Wirtschaftsgeme" +
            "inschaft,  gestützt auf die Verordnung (EWG) Nr. 1035/72 des" +
            " Rates vom 18. Mai 1972 über die gemeinsame Marktorganisatio" +
            "n für Obst und Gemüse (1), zuletzt geändert durch die Verord" +
            "nung (EWG) Nr. 1117/88 (2), insbesondere auf Artikel 2 Absat" +
            "z 3,  in Erwägung nachstehender Gründe:  Mit der Verordnung " +
            "Nr. 183/64/EWG des Rates (3) wurden Qualitätsnormen für Gurk" +
            "en festgelegt.  Bei der Erzeugung von und beim Handel mit di" +
            "esen Produkten hat sich namentlich hinsichtlich der Anforder" +
            "ungen der Verbraucher- und Großhandelsmärkte eine Entwicklun" +
            "g vollzogen. Die gemeinsamen Qualitätsnormen für Gurken soll" +
            "ten daher geändert werden, um diesen neuen Anforderungen Rec" +
            "hnung zu tragen.  Diese Änderungen schließen eine Änderung d" +
            "er zusätzlichen Güteklasse gemäß der Verordnung (EWG) Nr. 11" +
            "94/69 des Rates (4), zuletzt geändert durch die Verordnung (" +
            "EWG) Nr. 79/88 (5), ein. Bei der Definition dieser Güteklass" +
            "e ist sowohl dem wirtschaftlichen Interesse, das die Erzeugn" +
            "isse für die Erzeuger haben, als auch der Notwendigkeit Rech" +
            "nung zu tragen, die Bedürfnisse der Verbraucher zu befriedig" +
            "en.  Die Normen gelten für alle Vermarktungsstufen. Die Befö" +
            "rderung über eine grosse Entfernung, die Lagerung während ei" +
            "ner gewissen Dauer und die verschiedenen Behandlungen, denen" +
            " die Erzeugnisse unterzogen werden, können aufgrund der biol" +
            "ogischen Entwicklung dieser Erzeugnisse oder ihres mehr oder" +
            " weniger leicht verderblichen Charakters gewisse Beeinträcht" +
            "igungen nach sich ziehen. Diese Beeinträchtigungen sind somi" +
            "t bei der Anwendung der Normen auf der auf die Versandstufe " +
            "folgenden Vermarktungsstufe zu berücksichtigen.  Aus Gründen" +
            " der Übersichtlichkeit und der Rechtssicherheit sowie im Int" +
            "eresse der Beteiligten empfiehlt es sich, die so geänderten " +
            "Normen in einem einzigen Text zusammenzufassen.  Die in dies" +
            "er Verordnung vorgesehenen Maßnahmen entsprechen der Stellun" +
            "gnahme des Verwaltungsausschusses für Obst und Gemüse -  HAT" +
            " FOLGENDE VERORDNUNG ERLASSEN:  Artikel 1  Die Qualitätsnorm" +
            "en für Gurken der Unterpositionen 0707 00 11 und 0707 00 19 " +
            "der Kombinierten Nomenklatur stehen im Anhang dieser Verordn" +
            "ung.  Diese Normen gelten für alle Vermarktungsstufen unter " +
            "den in der Verordnung (EWG) Nr. 1035/72 vorgesehenen Bedingu" +
            "ngen.  Auf den der Versandstufe folgenden Vermarktungsstufen" +
            " dürfen die Erzeugnisse jedoch von den Normenvorschriften hi" +
            "nsichtlich Frische- und Prallheitsgrad, die geringfügig nach" +
            "gelassen haben, und hinsichtlich geringfügiger Veränderungen" +
            " infolge biologischer Entwicklungsvorgänge und ihrer Verderb" +
            "lichkeit abweichen.  Artikel 2  Die Verordnung Nr. 183/64/EW" +
            "G wird wie folgt geändert:  - in Artikel 1 Absatz 2 wird der" +
            " zweite Gedankenstrich gestrichen,  - der Anhang I Teil 2 wi" +
            "rd gestrichen.  Artikel 3  Die Verordnung (EWG) Nr. 1194/69 " +
            "wird wie folgt geändert:  - in Artikel 1 werden die Worte »u" +
            "nd Gurken gestrichen,  - der Anhang VII wird gestrichen.  Ar" +
            "tikel 4  Diese Verordnung tritt am 1. Januar 1989 in Kraft. " +
            " Diese Verordnung ist in allen ihren Teilen verbindlich und " +
            "gilt unmittelbar in jedem Mitgliedstaat.  Brüssel, den 15. J" +
            "uni 1988  Für die Kommission  Frans ANDRIESSEN  Vizepräsiden" +
            "t  (1) ABl. Nr. L 118 vom 20. 5. 1972, S. 1.  (2) ABl. Nr. L" +
            " 107 vom 28. 4. 1988, S. 1.  (3) ABl. Nr. 192 vom 25. 11. 19" +
            "64, S. 3217/64.  (4) ABl. Nr. L 157 vom 28. 6. 1969, S. 1.  " +
            "(5) ABl. Nr. L 10 vom 14. 1. 1988, S. 8.  ANHANG  QUALITÄTSN" +
            "ORM FÜR GURKEN  I. BEGRIFFSBESTIMMUNG  Diese Norm gilt für G" +
            "urken der aus »Cucumis sativus L. hervorgegangenen Anbausort" +
            "en zur Lieferung in frischem Zustand an den Verbraucher. Gur" +
            "ken für die industrielle Verarbeitung und Einlegegurken (Cor" +
            "nichons) fallen nicht darunter.  II. BESTIMMUNGEN BETREFFEND" +
            " DIE GÜTEEIGENSCHAFTEN  Die Norm bestimmt die Güteeigenschaf" +
            "ten, die die Gurken nach Aufbereitung und Verpackung aufweis" +
            "en müssen.  A. Mindesteigenschaften  In allen Klassen müssen" +
            " die Gurken vorbehaltlich besonderer Bestimmungen für jede K" +
            "lasse und der zulässigen Toleranzen sein:  - ganz,  - gesund" +
            "; ausgeschlossen sind Erzeugnisse mit Fäulnisbefall oder and" +
            "eren Mängeln, die sie zum Verzehr ungeeignet machen,  - von " +
            "frischem Aussehen,  - fest,  - sauber, praktisch frei von si" +
            "chtbaren Fremdstoffen,  - praktisch frei von Schädlingen,  -" +
            " praktisch frei von Schäden durch Schädlinge,  - nicht bitte" +
            "r (vorbehaltlich der für die Klassen II und III im Abschnitt" +
            " »Toleranzen zugelassenen Sonderbestimmungen),  - frei von a" +
            "nomaler äusserer Feuchtigkeit,  - frei von fremdem Geruch un" +
            "d/oder Geschmack,  Die Gurken müssen genügend entwickelt, di" +
            "e Kerne jedoch noch weich sein.  Der Zustand der Gurken muß " +
            "so sein, daß sie  - Transport und Hantierung aushalten und  " +
            "- in zufriedenstellendem Zustand am Bestimmungsort ankommen." +
            "  B. Klasseneinteilung  Gurken werden in vier nachstehend de" +
            "finierten Klassen eingeteilt:  i) Klasse Extra  Gurken diese" +
            " Klasse müssen von höchster Qualität sein und müssen alle so" +
            "rtentypischen Merkmale aufweisen.  Sie müssen:  - gut entwic" +
            "kelt sein,  - gut geformt und praktisch gerade sein (maximal" +
            "e Krümmung: 10 mm auf 10 cm Länge der Gurke),  - eine für di" +
            "e Sorte typische Färbung haben,  - frei von Fehlern sein, ei" +
            "nschließlich aller Formfehler, insbesondere solcher, die auf" +
            " die Samenentwicklung zurückzuführen sind.  ii) Klasse I  Gu" +
            "rken dieser Klasse müssen von guter Qualität sein. Sie müsse" +
            "n:  - genügend entwickelt sein,  - ziemlich gut geformt und " +
            "praktisch gerade sein (maximale Krümmung: 10 mm auf 10 cm Lä" +
            "nge der Gurke).  Sie dürfen folgende Fehler aufweisen:  - ei" +
            "nen leichten Formfehler, der jedoch nicht auf die Samenentwi" +
            "cklung zurückzuführen sein darf,  - eine geringe Abweichung " +
            "in der Färbung, insbesondere eine hellere Färbung des Teils " +
            "der Gurke, der während des Wachstums mit dem Boden in Berühr" +
            "ung war,  - leichte Schalenfehler, die auf Reibung, Hantieru" +
            "ng oder niedrige Temperaturen zurückzuführen sind, sofern si" +
            "e vernarbt sind und die Haltbarkeit des Erzeugnisses nicht b" +
            "eeinträchtigen. iii) Klasse II  Zu dieser Klasse gehören Gur" +
            "ken, die nicht in die höheren Klassen eingestuft werden könn" +
            "en, die aber den vorstehend definierten Mindesteigenschaften" +
            " entsprechen. Sie dürfen jedoch folgende Fehler aufweisen:  " +
            "- Formfehler, die nicht auf eine fortgeschrittene Samenentwi" +
            "cklung zurückzuführen sind,  - Farbfehler auf nicht mehr als" +
            " einem Drittel der Oberfläche; bei Gurken aus geschütztem An" +
            "bau sind starke Farbfehler jedoch nicht zulässig,  - vernarb" +
            "te Risse,  - leichte Schäden, die durch Reibung oder Hantier" +
            "ung entstanden sind, sofern sie die Haltbarkeit und das Auss" +
            "ehen der Erzeugnisse nicht wesentlich beeinträchtigen.  Gera" +
            "de und leicht gebogene Gurken dürfen alle vorgenannten Fehle" +
            "r aufweisen.  Krumme Gurken hingegen sind nur zulässig, wenn" +
            " sie ausser leichten Farbfehlern keine anderen Fehler sowie " +
            "keine andere Verformung als ihre Krümmung aufweisen.  Leicht" +
            " gebogene Gurken können eine maximale Krümmung von 20 mm auf" +
            " 10 cm Länge der Gurke aufweisen.  Krumme Gurken können eine" +
            " grössere Krümmung aufweisen, sie müssen getrennt aufgemacht" +
            " werden.  iv) Klasse III (1)  Zu dieser Klasse gehören Gurke" +
            "n, die nicht in die höheren Klassen eingestuft werden können" +
            ", die aber den Eigenschaften der Klasse II entsprechen.  Kru" +
            "mme Gurken, die wie in der Klasse II getrennt aufzumachen si" +
            "nd, dürfen jedoch alle Mängel aufweisen, die in der Klasse I" +
            "I für gerade und leicht gebogene Gurken zugelassen sind.  II" +
            "I. BESTIMMUNGEN BETREFFEND DIE GRÖSSENSORTIERUNG  Die Grösse" +
            "nsortierung erfolgt nach dem Stückgewicht;  i) Das Mindestge" +
            "wicht für Gurken aus dem Freilandanbau beträgt 180 g;  das M" +
            "indestgewicht für Gurken aus geschütztem Anbau beträgt 250 g" +
            ".  ii) Unter einem Schutzdach angebaute Gurken der Güteklass" +
            "e Extra und I müssen u.a.  - mindestens 30 cm lang sein, wen" +
            "n sie 500 g und mehr wiegen,  - mindestens 25 cm lang sein, " +
            "wenn sie 250 bis 500 g wiegen.  iii) Die Grössensortierung i" +
            "st obligatorisch für Gurken der Klassen Extra und I. Der Gew" +
            "ichtsunterschied zwischen der schwersten und der leichtesten" +
            " Gurke in einem Packstück darf nicht grösser sein als:  - 10" +
            "0 g, wenn die leichteste Gurke 180 bis 400 g wiegt,  - 150 g" +
            ", wenn die leichteste Gurke mindestens 400 g wiegt.  iv) Die" +
            " vorstehenden Bestimmungen gelten nicht für »Kurze Gurken.  " +
            "IV. BESTIMMUNGEN BETREFFEND DIE TOLERANZEN  Güte- und Grösse" +
            "ntoleranzen sind in jedem Packstück für Erzeugnisse zulässig" +
            ", die nicht den Anforderungen der angegebenen Klasse genügen" +
            ".  A. Gütetoleranzen  i) Klasse Extra  5 % nach Anzahl Gurke" +
            "n, die nicht den Eigenschaften der Klasse entsprechen, die a" +
            "ber denen der Klasse I - in Ausnahmefällen einschließlich de" +
            "r Toleranzen der Klasse I - genügen.  ii) Klasse I  10 % nac" +
            "h Anzahl Gurken, die nicht den Eigenschaften der Klasse ents" +
            "prechen, die aber denen der Klasse II - in Ausnahmefällen ei" +
            "nschließlich der Toleranzen der Klasse II - genügen.  iii) K" +
            "lasse II  10 % nach Anzahl Gurken, die weder den Eigenschaft" +
            "en der Klasse noch den Mindesteigenschaften entsprechen; aus" +
            "genommen sind jedoch Erzeugnisse mit Fäulnisbefall oder ande" +
            "ren Mängeln, die sie zum Verzehr ungeeignet machen. Im Rahme" +
            "n dieser Toleranz dürfen höchstens 2 % nach Anzahl Gurken an" +
            " den Enden einen bitteren Geschmack aufweisen.  iv) Klasse I" +
            "II  15 % nach Anzahl Gurken, die weder den Eigenschaften der" +
            " Klasse noch den Mindesteigenschaften entsprechen; ausgenomm" +
            "en sind Erzeugnisse mit Fäulnisbefall oder anderen Mängeln, " +
            "die sie zum Verzehr ungeeignet machen. Im Rahmen dieser Tole" +
            "ranz dürfen höchstens 4 % nach Anzahl Gurken an den Enden ei" +
            "nen bitteren Geschmack aufweisen.  B. Grössentoleranzen  Für" +
            " alle Klassen: 10 % nach Anzahl Gurken, die nicht der angege" +
            "benen Grössensortierung entsprechen. Diese Toleranz gilt jed" +
            "och nur für Gurken, deren Grösse um nicht mehr als 10 % von " +
            "den festgesetzten Grenzwerten abweicht.  V. BESTIMMUNGEN BET" +
            "REFFEND DIE AUFMACHUNG  A. Gleichmässigkeit  Der Inhalt jede" +
            "s Packstücks muß gleichmässig sein und darf nur Gurken gleic" +
            "hen Ursprungs, gleicher Sorte oder gleichen Handelstyps, gle" +
            "icher Güte und gleicher Grösse (falls nach Grössen sortiert " +
            "ist) umfassen.  Bei Gurken der Klasse III kann sich die Glei" +
            "chmässigkeit auf den Ursprung und die Sorte oder den Handels" +
            "typ beschränken.  Der sichtbare Teil des Inhalts des Packstü" +
            "cks muß für den Gesamtinhalt repräsentativ sein.  B. Verpack" +
            "ung  Die Gurken müssen so verpackt sein, daß sie angemessen " +
            "geschützt sind.  Bei der Verpackung müssen die Gurken so eng" +
            " geschichtet werden, daß keine Transportschäden entstehen kö" +
            "nnen.  Das im Innern des Packstücks verwendete Material muß " +
            "neu, sauber und so beschaffen sein, daß es bei den Erzeugnis" +
            "sen keine äusseren und inneren Veränderungen hervorrufen kan" +
            "n. Die Verwendung von Material, insbesondere von Papier oder" +
            " Aufklebern mit Geschäftsangaben, ist zulässig, sofern zur B" +
            "eschriftung oder Etikettierung ungiftige Farbe bzw. ungiftig" +
            "er Klebstoff verwendet werden.  Die Packstücke müssen frei v" +
            "on jeglichen Fremdstoffen sein.  VI. BESTIMMUNGEN BETREFFEND" +
            " DIE KENNZEICHNUNG  Jedes Packstück muß zusammenhängend auf " +
            "einer Seite folgende Angaben in lesbaren, unverwischbaren un" +
            "d von aussen sichtbaren Buchstaben aufweisen:  A. Identifizi" +
            "erung  1.2 // Packer und/oder Absender // Name und Anschrift" +
            " oder von einer amtlichen Stelle erteiltes oder anerkanntes " +
            "Geschäftssymbol  B. Art des Erzeugnisses  - »Gurken, wenn de" +
            "r Inhalt von aussen nicht sichtbar ist,  - »aus geschütztem " +
            "Anbau oder gegebenenfalls jeder andere gleichwertige Ausdruc" +
            "k,  - »Kurze Gurken bzw. »Minigurken.  C. Ursprung des Erzeu" +
            "gnisses  Ursprungsland bzw. Anbaugebiet oder nationale, regi" +
            "onale oder örtliche Bezeichnung.  D. Handelsmerkmale  - Klas" +
            "se, gegebenenfalls »Krumme Gurken in den Klassen II und III," +
            "  - Grösse, ausgedrückt durch das Mindest- und Hoechstgewich" +
            "t (falls nach Grössen sortiert ist),  - Stückzahl (wahlfrei)" +
            ".  E. Amtlicher Kontrollstempel (wahlfrei)  (1) Zusätzliche " +
            "Klasse im Sinne des Artikels 2 Absatz 1 der Verordnung (EWG)" +
            " Nr. 1035/72. Die Anwendung dieser Güteklasse oder einiger i" +
            "hrer Kriterien unterliegt einem Beschluß nach Artikel 4 Absa" +
            "tz 1 der genannten Verordnung.";

    String longCode = "t)....:,,:,e,e,,,,:,,,,::,:,::d,,,.,,,,,,,s,,gIIIaG.:..:...." +
            ".l.........n.t..G,gN..132.G..4..nn8N.aIgN-N...nG....:G..s.*." +
            "N)I;-,;n:.....,...N842500500I  e 8 s s 8nggggggGgetnnrlleN  " +
            "                II      II               r277ndllzzl....m  :" +
            " sfff::L-...L0..L..m nm-L.met..0...i.ii..rlsslzlnmsmetmmlzs." +
            "lsl.ss .es...    )))))s E2412mre.mmm.nnrnerrmdrehhhhhhh. nn " +
            "f  hs hr ennsm    ......NNNNNneeeen .  nmrrnmrem n n N8DDDD " +
            "D) nr.   .. )        .. ).  .   m GRnnnnndnnenerneeedhdrrern" +
            "sssrrreeenTe-enneennrrn-r mnnhMeerttt   ERedd mnnnrtsr.endrn" +
            "-hhnee.drsrernerrrrllrrieeirrr  er.dreeeereeeere erlllnnllee" +
            "Er ernrr. eem.nndr,deeeegd deeeeeeenn eeded  ... rrsmmn. ..E" +
            "REe))))rr))rrrrr))rrrrrnererre-rennnnne.rrernr   eeeee....se" +
            " rmmm.eennns.nnnss mennn/neereennr)))))))gg.)....rrr/mmsesss" +
            "ndn rrnennmmssstnrhfe,,,,,eeeemnehnr .. mnerenrm-EIensenrrer" +
            "rn-e)r.nn   E gerrnrenneeerrereereeerrn.drernsemmmnr sne  mm" +
            "r)eeeetnrhrrnnnnhr,rgntdrnndererrrrhrretnsmmmeettntetrtdrtng" +
            "lgkregekrrntnnnr,;;;gnnehtu;stduophmuure00tnnden00050nkdntdh" +
            " ,,,,,ddtshl,trttrrnnirrnhhnfnffnrrrr,h--ieinigneeesdnnnnnnn" +
            "nnnnnnnn9ghldnhhnenn1ßtintnfndh1,dn,dgdn,etgtlsnG92ged,rsnnh" +
            "enntde,rr,ffdrfhhfn,,,,,,,,r,nn,rnn,,,,,,,,,,,d,,,ntmgnguunn" +
            "nngentttnnezz,e,ef--rnenntsnrnnn-fndnnnr,nnmnoneeIgnnngntddg" +
            "eßt)-nnehneeeee-hh--nhnnnkntthntnnrnsnnßerenInt00000000-tttt" +
            "tr,eennneeere---nhhreehgnssshndd  -nIsrttrttomzdrnd,,ßeete--" +
            "hngrnne.nnnhdnnnee   snrdr     .Insee----n 9tngeentteengrdnn" +
            "-end,,,,gge,ttr   rnnstdnnrretenInßenn,nnnnnmmddr--rneernttt" +
            "ettsd--eeeensl000sslnkdgnenenIeenee%%%%%%%ßnsstngrghrßnhes-n" +
            "eeeenfeemfnehreehfhdtrgglllseeueetgtre--,dd,ts,-nreerngtttno" +
            "tnggvhntnnthstrnnßnnßnn,neeennnnnnutnnnntnndneßn,,,endenntrt" +
            "druugen,e)n1egtt--t-aaII-gnnttnedgrhe,eneegnttrnrhrrrg.tnne," +
            "nte-oefsng0 s8277gigegiiitdh%ri-nniigne2gnegeehr,,,,,,1ntttn" +
            "ttttdderggg22IG9m)rgh-reggnnn,,tetrreeen gnggngßtrrds-s-r.t-" +
            "eeererr2g                                    i135214iiviiiii" +
            "ivvGGGGGGGGi1st3ten5214ie****￭tdI)nn)fnn)tznrenenntgnnktkt3g" +
            "28948neennnnlnrenntgnnnnrrnndnrgnnnnnnnnhnnnd)ness)grlnnreun" +
            "ddgnnnnggnng))                                       rete   " +
            "   1141ann8nnnnnnnnntdtngnnnnnngtn)nrdnnnnn)ntnndgnntnnSSS4r" +
            "rr5rrrrrrr16541S808rSEwBIVIIIVnI2nnnnnABrADAnn155Brrrr8Allll" +
            "lnnCBLnww1ug//  7334455579744dd1111008511130000055821112  55" +
            "441111771      1 ((((   1                     1          211" +
            "       11           .  797  7((77  3       (( 88  000   ((66" +
            "1 9966   12((2 11333212  1 9///1//9000511700//99/6 88888188 " +
            "221111199///999168667111111111111snnnnnttnNetngggtnnde      " +
            "   MHHU H RLH                                               " +
            "        S                            AAAAA    SSSIA (»NNNNN " +
            "N        RRN                                IIIIIID TRRRRRBZ" +
            "EMGTHZKSTGGGGGSFFFFFGKGSDDL VVIIBBBBBBBBBBB //((((((((      " +
            "                            FFFFFEEEEEIU FAA                " +
            "            NNNNNNNWWWWWWWWWW NNNNNLIE                      " +
            "                                                         »  " +
            "        CCN CCC           II II I I IIIII IIII IIV EDDDDDDTR" +
            "RE I I     II  VII       TTTTTTESSÄMML               R      " +
            "                                          »       »»     ROO" +
            "A      RFEMMOOIIIIIIMMMMMM             »      EEEEEOEEEEEEOE" +
            "EEEEEEAUUUUAUUUUUUUAESEIEHDDNA                         TFKKI" +
            "IRRRNS              O       EÜEEOOTTTTTDGUEOUEEOE           " +
            "G     FNNISSSSSTNEAÖIIEEEEEE                       AÜFFRSSSS" +
            "SS EEEEEÄ            »  IQAHRMNNNMMMMMGE       I            " +
            "                              EEEEEEEEEE   NN      rrrr.ttgh" +
            "hgh      nnnnnnnnnnndnnmmmmnnnWmmmmPPPPPPPPpppprrrrrhhrhhhhh" +
            "hhhhhhhrrrLdzzzzzzzzwwnnnRRnMrrrrrriimmmmmnnhmuuuuuufff     " +
            "   f rffff     hhhHHhhhhw  sNsSSSnsss    dttltlHHhHHt      h" +
            "ss hhhlls    ggd kknnk rrrHHHJrrrgrrrrrrrPubbwhFrFFFnnbbbbbd" +
            "ddtbbMmmmmdddDddDlllllllllllllllllllllllllllllllllllllllllff" +
            "lllhaMMRRRsntsglrssssbbbbss rrrD                            " +
            "  b  »       bs   bmmmddddMltttthsttnnnnnner  sss rr    raaa" +
            "aaaeeeeaaaaüüuufOeÜ   ssss  r  rrrerm       rroeeemrrrAAAAAA" +
            "OOerrrriiraaA   aaaaaaaaaoiaarroiaiiraooiuiiiirrossssssiiiii" +
            "ooooiaiuooiissssssssssssssSsisisässisiiiisiisesaiiaeeiiieeaa" +
            "eeesiiiiuluuiasssiisssssssssiiiseeiisssssuaaöööeaiiiiiiiiiii" +
            "iiiiiiiiiiiiaiiiiiiiiiiiiiiiiiääuääiiiieiisSsiSsSSSssssssaaü" +
            "üüuaüiiiaüiiiiiiüüüüaaaaaaaüaaaaüüüüü     unnnnnnnnnnnnnnnnn" +
            "nnnnnnnnnnnnnnnnrnnnnnnnrrnnnnnnnnnnnnnnnnnnnrrenannnnnnnnnz" +
            " ne            nnneaaaan  nnnnn  mee n   n              r  n" +
            "n  nrännä o rrrn rärrrre   eiIno    o    o  on      o       " +
            "                        eoooo     eeoo o oo  oo oo     onrrn" +
            "nnnnnn nnnnnnnnnnnrrrrnnn     e e       nnnnnnnnnnnn        " +
            "                                                            " +
            " enenäänrrrrrrrrrrrrrreeeeeeeeeseemmnnonnnn     n       elis" +
            "sskiigdigissihsniiiisssgkddrhtiiittztnmmmniiiiinmziiisssssss" +
            "sssssssihsdilirrlllimtlissiiitinittiirgsnlrlliiiiissiiiiiiin" +
            "niriikligbsgggsnmiiiiitrssltffiinsnssiissnirnnniiisiiikisnsi" +
            "iinkssskissiiiiiiiiissststslddiiiirltsmstgddsiirliiiifsiiitn" +
            "snkksgsskslthdhggggglgggglrrrrrrrrRRoRiGjjjiijwwJjiBjjjjjjjj" +
            "igiBtgggbbBBbbbiddDggbmmBggggglgiirjiiligbbBsttsittttssfFFFf" +
            "FfffffFimmmzzzmggbBbbBBBrrrrrrrrrRRwllwllllllzlLllwlllllllwl" +
            "tttteeeeTTrTtTtttbsssssssssssssssss ss kkk        k         " +
            "      mmm   neeee wwwwwwwwwwwwkkkkkhkkkwShbrttttpkkkkkkkkgtd" +
            "sgggtgitthtgggkddddkkkgggttthndndddndnddhndgrrrggggitT gGGkz" +
            "tzkndnudnndrhsdddddddhdsttrthrdrrtrntrrhdhsshndrrtlnhtddrrrt" +
            "tdsdmgnhrggdhdddtdrhtsfkkmnbkkknnkthkznzntkttttkhkgdgkhdfnss" +
            "dkkmmdkfnnßddssslltmtttdkdfsmmmmttkgmmgsskskstgktfflhdkdmbdg" +
            "fffskkddhnkskkskgsltsgrffzssmzmggrhdrsrksksssttrrfilsskdkgkz" +
            "trghhhbggfhbdgkgnnhhtdskkkkkkkkbdsdbrkgshhhggsmsknkgdsggkssh" +
            "ssgggsdfghhhhhgsssssshhggghhrrggggglhggshwwwwwwgggtsghdbbhsd" +
            "ddbbmmmnnl mwmwwwwwwrrggtttttggggggggggsssdkdsdsmss         " +
            "    nnntmmrgggggrztdddddddrddhdsdddrlddDhddddddhdssdDddddddd" +
            "ddddsssdddgdhrdddttdnhdssdddddrddddssddgDnddddddddllllddbddd" +
            "tbbbbbtddddnhdggddlgsdiddidsDlubkdddhddddldllhllbhthggGgllll" +
            "llllllVpdvddVVVwwwwwwwwwvVlsddddddbdttdhhdddnsdsttb Vhtttggg" +
            "nmMtVVVVnlblfffvvKfVVVVVVVVVVVVVVvVVVttVVtvbwddiiddd iiidwwV" +
            "GiidiiifiiigdddddddhhVvvVvVVVtVVbBssttddddtddddddddddd srst " +
            "tGlbggBGGGBgbGGggggiiiiiiiiggiiwiiiiiiiiiigbbbbbrrmfdttddddt" +
            "dddffddbBBbBggggFgggggnnnitddBgtggbbkllssnFnzzzzzzzzzzzzzzzg" +
            "gggGggTBiiiigggggguuuuuuuuuuuuuuururfreee n((nmuuuuubbmnmmbr" +
            "rurrrrruffufuooote   oaoouupeeeiurrn       rnnneer        ll" +
            " ue  iuuaaaaaaaaaaaiaiiaäaäiuuuuuuuuuuuuueeegguuuu          " +
            "            nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnninnnninnnnn" +
            "n nnnnnnnn   nnnannnninnini  inn nnn nner iniiilnnnnnneeeeu " +
            "  snnn  rnn  ne  nhuutnnn   f  sn niinnnnnnnnenonennaüniiaiü" +
            "eüoir nüülllllooonssiiiiiiiiii     iiuii      a st    rrt   " +
            " nn   n  tttk        nnnnüü   eooiiii       etniiiuuuuuuuuuu" +
            "uuus f  nnnnnnnnnääellleeeiäuiinei    rccccccccccccccccccccc" +
            "ccccccccccccccccccccccccccccccccccc   cccccccccccccccnnnseen" +
            "ßennnC ccccccrl ccccccccccccecceecccecccccccecccccceeeeeeccc" +
            "ccaccccööc  cccc    ccaaaaaaaaoeeeeeeeeeeeeaaccccceccccaaaaa" +
            "acccccccceeeeeeeiiüüüüääiiiccccücccccccccccccccccccccccccccc" +
            "cccccccccccccccccccccccccccccccccccccccccccccn     eeccccann" +
            "eeeeeeeeeeeeeee i  iiiiierreellllllllslrllselsslllllellerrer" +
            "reeleslleeeenwnnnnnnnnnwwneeennnnnnennewsssseeeeeeehssssswee" +
            "wwwwwwwwwssssDdDdddddDDDDddddddddddDDDDddddddDdDdDdddddsddsd" +
            "sdSSwwdDdddwdwDdwddsSSdddddddddddsdDdddssshhrrnlLwwlwwzfrzrv" +
            "pttnnnztttttttDdDDDDDDddddddddddddblllltrrggrgssssslttrzstdt" +
            "teEEEEEeeeetgnnsdsteeelttn     i  ii    tttttttttteeeeeeggge" +
            "ee  e   xxxtttttee        ee              ee  eeeeeeeeeeeeee" +
            "sssssssssssssssMMMMMmmmMMb eeeeeeeeeeeeeeeeeeeeeeee rlhleeer" +
            "rdtffbeMfES ee    eeeehhheeeeeebbsttgttwwwwwwWbbmnnnntttrttw" +
            "prrrgpäwgeeeeeeeeeeeewnnnnnnnnnnRwnnnnm       emmmmeeemmMeme" +
            "eeeeerMnsernrmrbbbeellllllt   tVf              ccccccc  rrrr" +
            "rrcrrr    gghgrrhgiiiiiiiiicccrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr" +
            "rrrrrrrrrrrrrrnrnciceeeenfccccccrrncccccccccccccruaaaaaarrrr" +
            "rcccccccc      oeheeeeeieeehhhhhhheheieallleaBBBBBsi  KKkKKK" +
            "KKKKKKKKKKKKKKKkKKkKKKKkKKKKKKKKeKeKKekeoalaaallllalallakKne" +
            "ggggggGG          glllllilalhhhhhhahhhhoooooooooolhh uuhhooo" +
            "ooooooltßtttßßttmtdtzbgztttbtgrhhhhbiddaaaaaaaaaaaeaaeaaaääa" +
            "aeaeaaaaaooeoeeeuuuoohaeaiaallllaeeleehiaiaeeiaeiaaleeeaiaaa" +
            "aikkkkkdlkhlfuuuuuaoooooooieeeieeaeeeeiiiccceeeIIeieuuueemmm" +
            "ruerccueu   ehhhkiiikorrrr ((oyeeemmmmahahh    eeearhhhrrrrr" +
            "rrmmmaaamoarmseurrr   um    o  ne   uuuuoooaaoiüüüüüiiiieeeu" +
            "mrraaArmmmmmmmmm     shhheee             eoeeeeiieeoeeeiiiie" +
            "eieeeeeeeeeeeeieeeeeoeeeeeeeeeeeeeeeeeeeeeeeeioeeeeeeeeeeeoe" +
            "oeeeooeeeeeeeeeeeeeeeeeIiieeoeeeeeeooeeeeiaaioaoeieneeeeeiie" +
            "eeeeeeeeieeeeereeeeeiinneoeeeieeeeeeiieeoeeeeeeeeeeeeeeeooie" +
            "eeeoeeeeeeeeeeeeoeeeeeeeoeeeeeeeeeiieeoereeeeeeeireeeeeeeeee" +
            "eeeereeneonnnrreeeeeeeeeeeeeeeeeeeoieeieeeeieeeeeeieereeeeee" +
            "eieeeeieieiieeeeeeeeeeeeeeellleeeieeeeeeeiieeeeeeeeeieeeieee" +
            "eeeeeeeeeieeeeeieneeeeeeieeeieeeeee                gssßoo ee" +
            "rr aAAAAAuuuuiiuuuuuuuuuuuuuaaeuauueeauuuueuuueeeuuuuiuiuuuu" +
            "iuuuiiiuiiiiiiiuuuaeeeüaaaaaeeeeüEEaeeoaooaooaaaaoääääääÄääÄ" +
            "iiiiiiiiiieeeiaaaüeeeiieeeeiiiniiiiiiriiieiiiiioeeeeeeeniiee" +
            "enninnneeeeeiiinanggg  eeeiAAAuuuuuuuuuuauuauuuuuuuuuuuuauuu" +
            "euuuuuuuuuuaauuuuuuuuuuuuuuuuuuuuuuuuuuuAaiääääiauuuaaiääääa" +
            "uuuuuuuuuuuiuuäaiiiiiuuuuuuuuuuuuiIiIIAAAeuur               " +
            "    iiiieialllfgggggggggggggihäaeaiueeeaeeeaiööööööiIeeaaa  " +
            " aeesssseeeeeaoiiiiiiieeeeeeeeeeiiiAiiieeeaaeeenneinnuUuIIuU" +
            "uunEaaaeeeeeoiiiieeeeeeeeeeeeeEEeeeEeaddddddddddddhhrhdd   u" +
            "eAAaaaaAAAAAAAaaaaaaaieeeeeeesssss ddnnddddddnB/  /         " +
            "      rHssstttzzbbbllwbsTTTttTTTtTfffffffffrsviivvvvvvvnKNsn" +
            "nkKivvvvvvvvvvvvivvvivvvvviiSsssssihKrvvfffrrrrrrrrrrrrrrtvv" +
            "vvvtNNNnnnnNNNNFFFfffCvvvvspSSSWssfssssspprlNsssryrrrrmmmayy" +
            "ssr     sssssssssssseeyoeeaeeeeeeueeeeeeüeeeueeeeeeeueeeeüüü" +
            "üüüüueüüeeeeeeeeeeeeeeeeeeeeeeeeeeeueeeüüeeeeeeeeeeeeeeeeeee" +
            "eeeeeüüühheeeeeeeeeeeeeeeeeeüeeeeeüüüüeüeeeueeeüeeeeeeaaüeee" +
            "eeeeeeheeeeueeehhheeheeueeeüeeeaeeeeeeeeNNNNNNNNNNNeNNNNtttt" +
            "geeeeKtttapppppPFTTeeeeeeeeeeeebbbaooaeaaaeeeeeeaaäääuuuuuii" +
            "iiiueeeeeeeeeeeöoooooooooooooooooeehaeeeeeepppppppp ffffffff" +
            "fFefFFaeaeeeööeeeeehehhhheauahhttG eehhheeaaaüüüüüüüeüeeoooo" +
            "ooeeetttttfftehhhdeeeoFffKtDheuauuuuuuaauuuuuuuuuuuuuuuuuuuu" +
            "uuuuuuuuuuuuuuuuuuuuuuuuueeäaaaaaeooeeeeoooooooooooooooeeeee" +
            "eeeeeoePtueeeeeeeeeeeeeegGeeeeeoeeeeeoeUUUUooeoAeeeeoeeeoooo" +
            "eeeeeeooooooooeAAAAAAAAAöeiioedrKKKKgeeepeeeeeepeheeeeeeeepp" +
            "aeeeeeeeEuueeeEEEEEEEEEEEEEEEetttttteehppGGGGGGGGGGggeduuuue" +
            "KKKKKGGGBeeeelnlnnninineaeeeeueuaaaeeeeeeeeeeleultaleuuurlal" +
            "emkklleeiekeulnpglnnuuerrti bbbb  geiiinnnniiiiiiennnnnnnnnn" +
            "nttiiiiiiiiiierr nnneeeeebnreees teeeeeeuüsüsessssssssssssss" +
            "sssseeeeeessssssssssssssssssssssssssessssssee               " +
            "    sssssesssssssssssssiessssssssssiisissiiiiiiissisbsssssäe" +
            "sseeeeeeeeeesssssssssetutuuutu    s    knnnrä           ssss" +
            "ssss               soglluutttt           eeeeegu   nnn   nnt" +
            "tttttttrrrruöioaaaaaaaaaaaaaaaaaeiaaiaaaaaaiiiiaaiaaaiöaiiiö" +
            "eauuüiaaaüüüaaaüüeüaiauuoaüööüüüüaaüüaaaöööööuööuuiiuitäääää" +
            "äääiggggtiiibbiiieiedhuuut ee thrrheeeenlerheeheheeheeeeeeeb" +
            "ddneeeeueddsssseehllkkkkkkkeeetgsuunihggiiiiiitrizhzhnnhihhi" +
            "hhhihrimikrrgulhhlhhhhuuzzgghshhrrlleeehhgseflällkäahbzisssr" +
            "iimmlhlfferehhhsxtssgissflsgafhgrrlhsssssssnhhhhllissuebhhki" +
            "rrrürüüsssssssssseernüüüüttSsSzzzsfhnhzsrrrrnrlfffffgfffllkf" +
            "llsrftsssssrtsunnnttnnaainnknnaanlahhhhünsrssssirrnrnrrntnrf" +
            "hhhfhhhrrrrrrrrrEsssssmiaaikkkkkaahnlhlhnrfmmhsssnenkaxxxxr " +
            " eessssss nnnnneelfrrrsfiäääännnnnnnnhfnnhiiiiiiiiesssssssss" +
            "fiilkkkkaaonnnnnnnnns nsaaaauääüüeeüüüüeeiiiiiissssSsssSsszz" +
            "aaZZaazze QQQQQQnaaaraaaBerCeaaaaaaaaAaaaaaaaazAttttrttaaAzt" +
            "taaaaaaaaaaaaazzzzazzeeeeeeeeeeeeeeedzzäääzzzzzzzz  z crrrrt" +
            "        »            r                    srklnnnnnnnnnmkmmr" +
            "ddrrbldrrrbhrnrkgtbrnttrrlmdzgnrrnnlllrbnbnnnmm   rrrmmrrgrg" +
            "mlg  lrtrmttttlJJ  r s  zzznzntndddddwtGGGGGGGGgGGGGGGGGGGGG" +
            "GGGGGGGGGGGGGGGGGGGGGGGGGGGGGgGEKKzzzzAvaaaaazzAaaaaaAAaaAAa" +
            "aaäähZZZdZzgggaghmmlmmmiiii        n                        " +
            "      (r   srn  izzz((r    bbbffffffffffffzrrtnnr           " +
            "     hzh eeeeettttttttt  o o          rzeeo r  aaaeEEEEstttt" +
            "ttttnnnnknnnnnnntrrrrrennnnnnnirrrrrrrrrrrrrrr  inttrltttttt" +
            "ttt    n kkkk            ft           bbb n          PT  RFG" +
            " äauuauuaauueoeeealrrrrhhhhhhhrrwwwpffeeeeeerrLLLgMMMMhrFFFm" +
            "rrmlllllmmttttttssFFF  mhhhhhkkkkkkfhh rrrrrrrrrrrr  ttttttt" +
            "trrtrrrrnnnnnffffffrrrrrrrrrffffffffffffFfffffFfffffdddddddd" +
            "mmrmmmmmmmmmmmmmGGGGGGGGtthhhh.";

    @Test
    @TestValue(3)
    void transformShortSlow() {
        assertEquals(shortCode, Volltext.transform(shortPlain));
    }

    @Test
    @TestValue(3)
    void transformLongSlow() {
        assertEquals(longCode, Volltext.transform(longPlain));
    }

    @Test
    @TestValue(3)
    void retransformShortSlow() {
        assertEquals(shortPlain, Volltext.retransform(shortCode));
    }

    @Test
    @TestValue(3)
    void retransformLongSlow() {
        assertEquals(longPlain, Volltext.retransform(longCode));
    }

    @Test
    @TestValue(5)
    void transformLongFast() {
        long shortTime = measureRuntime(()->Volltext.transform(shortPlain));
        long longTime = measureRuntime(()->Volltext.transform(longPlain));
        System.out.printf("%d %d%n", shortTime, longTime);
        assertTrue(longTime<60*shortTime);
    }

    @Test
    @TestValue(5)
    void retransformLongFast() {
        long shortTime = measureRuntime(()->Volltext.retransform(shortCode));
        long longTime = measureRuntime(()->Volltext.retransform(longCode));
        System.out.printf("%d %d%n", shortTime, longTime);
        assertTrue(longTime<60*shortTime);
    }

    @Test
    @TestValue(0)
    void testNix() {
        System.out.println(shortPlain.length());
        System.out.println(shortCode.length());
        System.out.println(longPlain.length());
        System.out.println(longCode.length());
    }
}