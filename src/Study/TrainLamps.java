package Study;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class TrainLamps {
	static class Position{
		long start;
		long end;
		Position(long a,long b)
		{
			start = a;
			end = b;
		}
	}
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
        long m = scanner.nextLong();
        long k = scanner.nextLong();
        long sum = 0;
       LinkedList<Position> []adj = new LinkedList[n];
       for(int i = 0; i < n; i++)
			adj[i] = new LinkedList<Position>();
       for(long i = 0; i < k; i++)
        {
            int r = scanner.nextInt();
            long c1 = scanner.nextLong();
            long c2 = scanner.nextLong();
            Position obj = new Position(c1,c2);
            adj[r-1].add(obj);
        
        }
        Comparator c = new Comparator(){

			@Override
			public int compare(Object arg0, Object arg1) {
				Position p1 = (Position)arg0;
				Position p2 = (Position)arg1;
				if(p1.start > p2.start)
					return 1;
				if(p1.start < p2.start)
					return -1;
				return 0;
			}
    		   
    	   };
       for(int i = 0; i < adj.length; i++)
       {
    	   
    	   adj[i].sort(c);
    	}
       
       for(int i = 0; i < adj.length; i++)
       {
    	   long prev = -999;
    	   for(int j = 0; j < adj[i].size() ; j++)
    	   {
    		   long a = adj[i].get(j).start;
        	   long b = adj[i].get(j).end;
        	  // System.out.println(a+" "+b);
        	   if(a > prev)
        		   sum += (b-a)+1;
        	   else
        	   {
        		   sum += (b-a)+1;
        		   sum -= (prev - a) + 1;
        	   }
        	   prev = b;
    	   }
       }
       
       System.out.println(n*m - sum);
       
    }

	

}

/*
 Test Case
959853793 843091218 336
523348535 528340894 840674764
61457428 826401957 841960745
546490614 43385521 432359067
587663994 239396594 785741557
282094466 122676556 528334928
622587269 278596387 451959834
299582872 707506180 763613497
761284569 504767741 524440946
881103723 496963640 637361482
88661179 384444117 458184327
783833383 377581696 548308918
548102394 54890493 277191483
79816181 271834609 342617390
93380124 747050567 776648727
507049262 830267378 839434463
421883186 287658263 446394700
612949748 298235799 785519685
6639829 537056563 785760805
729827454 78448207 568230502
173353136 524154377 841567756
577179333 677059445 679498408
25814087 221304202 603656287
483123344 591278195 766338259
803908869 629779972 675551892
931124597 246970238 833443818
577909439 203336898 585104762
947701130 348446625 400511701
181636204 47851803 158854201
916242354 49599213 477664021
907324977 518183877 537692989
244019699 233357761 567007432
111407526 596974800 671611739
553156389 77789986 651600408
656423107 114526865 433190855
914662600 663273541 815873925
183032729 11735301 342031867
372544340 24862983 395782457
257317699 671543760 677108171
519876838 288487360 775668232
551759977 495200197 780330503
367294261 290323939 787299968
757514149 204689268 338910188
240929389 644759165 747941238
253399427 224067799 326821142
9757135 159264992 623334442
195488794 439026252 659299182
478371109 725675594 841039431
85475304 490656364 743685886
927102597 562079334 602008279
936861165 488944633 576328447
931986027 386641423 664910328
770961856 566930055 673457718
417436905 79413534 192295913
491666698 225472908 507852257
624075363 744799027 816531767
261987964 106877583 621927705
590935189 212713960 580617599
373717943 592811245 819069044
899204650 830322168 834450829
476139111 763655660 789186619
172479025 451911318 526224503
738486566 229155463 424916149
128345292 632625643 682086321
55466666 91407013 133750655
882349940 331818616 406427027
379538945 641923714 706477731
51447128 421782761 829169139
344385058 610881865 656756392
7297739 265832315 734509269
551991258 353143735 771562223
477506707 448821341 696445529
688295195 675453751 716960533
434981458 585216883 585943845
768782712 730098481 798741600
408977919 76088216 502185670
726786078 6671495 61728430
528379773 512082632 776789047
298787629 181221760 464273178
903684747 590291715 598439751
874878034 724829732 774626492
494274557 266003540 399508262
143643190 581663096 837564540
127798157 62419265 121627865
213774931 415366163 564754724
236319909 532777679 616689694
584975710 753931841 765174230
96170787 248874440 687798082
256357765 232909425 363932218
816396213 353170293 741011952
755948019 6349596 193140244
546679988 314974763 389771341
419744390 744083349 841614717
935858214 820052159 829712274
859141185 381732929 497057059
325647578 58443605 674003729
340273230 308087764 451321999
287539982 434586953 620228779
835078986 78587177 815880963
801659084 725732726 727235535
386198695 553608450 764440524
196349289 268722530 411317928
65396825 546003729 761232289
10552255 668054237 741280313
242493457 282934641 390937579
744508459 744088371 820623237
476938886 261215306 345306347
871477870 740633972 771423309
876272495 383391423 730338177
744017429 731682325 737624570
241764811 89692121 658618877
610941052 523712771 699303999
491734259 134314055 418346917
236319909 532777679 675241904
55466666 133750655 541269993
244019699 567007432 567602002
491666698 225472908 412095519
257317699 671543760 760583538
882349940 406427027 751081974
386198695 764440524 778292325
55466666 133750655 525223445
477506707 696445529 802258666
899204650 830322168 836005683
622587269 451959834 463591094
947701130 348446625 589645630
261987964 106877583 361521803
914662600 815873925 841305865
577179333 677059445 698467862
590935189 212713960 679774443
372544340 24862983 70148916
916242354 477664021 651871970
770961856 673457718 768630669
507049262 839434463 840524502
242493457 390937579 608108129
835078986 78587177 219078813
874878034 724829732 761113121
548102394 277191483 658281674
96170787 687798082 735806280
546679988 314974763 798020650
584975710 765174230 814246727
79816181 342617390 578115287
434981458 585216883 595620618
859141185 381732929 620126679
882349940 406427027 771392465
434981458 585216883 656501957
770961856 566930055 797934461
476139111 763655660 783683471
587663994 785741557 833551878
688295195 716960533 727731849
88661179 384444117 797803082
927102597 602008279 728125307
553156389 651600408 709492192
738486566 229155463 418930921
507049262 839434463 841014932
298787629 181221760 750313186
931124597 833443818 835020451
548102394 277191483 341194526
379538945 706477731 726638512
624075363 816531767 839930737
899204650 834450829 839015327
408977919 502185670 669424894
907324977 537692989 570430401
65396825 761232289 814882708
927102597 602008279 821304154
507049262 830267378 840917172
213774931 415366163 684254613
434981458 585216883 605424360
183032729 11735301 108283613
551991258 771562223 775091898
931124597 833443818 835928907
936861165 576328447 612744793
196349289 411317928 535417688
507049262 839434463 840843161
253399427 224067799 811864443
7297739 265832315 778144472
931986027 664910328 792032681
590935189 580617599 610817428
882349940 331818616 726912873
744508459 744088371 771566061
287539982 434586953 709081685
173353136 524154377 636802110
927102597 602008279 719235731
907324977 537692989 779774560
111407526 596974800 749292753
744508459 744088371 809433847
546490614 432359067 731584711
881103723 496963640 756568068
931124597 833443818 841516219
195488794 659299182 841263746
519876838 775668232 842178999
546490614 43385521 99457833
783833383 377581696 769778696
528379773 512082632 743405966
801659084 725732726 802963650
373717943 819069044 822166003
172479025 451911318 731164581
916242354 477664021 777482551
10552255 668054237 802593118
936861165 488944633 699528917
282094466 122676556 305353790
367294261 787299968 792782731
935858214 829712274 830571783
903684747 598439751 748181529
770961856 566930055 803163369
299582872 707506180 826425571
85475304 743685886 789993830
417436905 192295913 753699172
242493457 390937579 842806410
688295195 716960533 751720728
914662600 815873925 826760719
899204650 834450829 842500470
761284569 504767741 625825318
744017429 737624570 835751289
367294261 290323939 583527460
408977919 76088216 381274823
419744390 744083349 812254641
213774931 564754724 754372420
903684747 590291715 782309585
914662600 663273541 713345993
299582872 707506180 751241205
519876838 288487360 365337352
408977919 502185670 736801829
548102394 54890493 89075965
61457428 826401957 836390385
421883186 446394700 819926237
494274557 266003540 812588531
744017429 737624570 785839632
610941052 523712771 675458488
261987964 106877583 172993606
835078986 78587177 654769946
127798157 121627865 827084333
590935189 212713960 387844870
882349940 331818616 558002807
421883186 287658263 802342191
476938886 261215306 799387266
551759977 495200197 582237701
936861165 576328447 724121126
726786078 6671495 172021856
257317699 671543760 689046398
916242354 49599213 832245763
477506707 696445529 817964595
546490614 432359067 758791572
494274557 399508262 422780456
373717943 819069044 839427401
344385058 656756392 738555739
477506707 696445529 747155041
476139111 763655660 807120439
379538945 641923714 660607484
528379773 776789047 827566737
236319909 532777679 725203803
143643190 581663096 631750492
835078986 78587177 240277408
25814087 221304202 353194525
9757135 623334442 636219883
871477870 740633972 802208975
9757135 159264992 760809649
93380124 776648727 777823012
899204650 834450829 834874316
79816181 271834609 623267409
483123344 766338259 830332934
491734259 418346917 558680200
172479025 526224503 641730842
111407526 671611739 774063287
491734259 134314055 330603285
744017429 731682325 734689747
936861165 488944633 752093170
907324977 518183877 724887407
859141185 497057059 704917727
494274557 266003540 721076265
528379773 776789047 822103021
196349289 268722530 395044871
298787629 181221760 433537520
111407526 671611739 693277296
298787629 464273178 514976053
914662600 663273541 789544785
584975710 753931841 830758078
551991258 353143735 394703745
477506707 448821341 669082452
577179333 679498408 736208656
548102394 277191483 478791500
419744390 744083349 804238491
882349940 406427027 560246425
551991258 353143735 770235389
256357765 363932218 401938081
903684747 598439751 765283629
859141185 381732929 767895730
299582872 707506180 800725215
213774931 564754724 707126932
340273230 308087764 818279958
553156389 77789986 335435186
688295195 716960533 719381869
183032729 11735301 382811344
876272495 383391423 399145334
587663994 785741557 841108140
882349940 406427027 506603820
729827454 568230502 794124885
874878034 774626492 828283940
173353136 841567756 841899483
947701130 348446625 681965080
261987964 106877583 148177099
10552255 668054237 754593280
803908869 675551892 678068250
612949748 298235799 763918747
241764811 89692121 519721028
931124597 833443818 842244014
803908869 629779972 661265207
236319909 532777679 746180693
916242354 49599213 249640874
196349289 268722530 364905517
882349940 331818616 698731991
551759977 495200197 707688197
859141185 381732929 741950623
261987964 106877583 372703909
10552255 668054237 748221886
242493457 390937579 584436199
729827454 568230502 568895765
553156389 651600408 709156334
65396825 546003729 654773226
299582872 707506180 785729183
859141185 381732929 502146034
770961856 566930055 829006078
907324977 518183877 605961630
801659084 725732726 832607706
483123344 591278195 617420664
871477870 740633972 809412394
803908869 629779972 824553628
7297739 734509269 753093200
931124597 833443818 842789733
738486566 229155463 553341999
528379773 776789047 840254913
25814087 221304202 705790862
899204650 830322168 834177244
417436905 192295913 327088114
761284569 524440946 624789567
419744390 841614717 841752098
257317699 677108171 701824499
882349940 331818616 388007763
 
 */