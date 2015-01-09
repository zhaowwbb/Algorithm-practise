package com.rick.algorithms.ssearch;

import junit.framework.TestCase;
import com.rick.algorithms.util.Util;

public abstract class AbstractStringSearcherTestCase extends TestCase {
	protected StringSearcher searcher;
	
	protected abstract StringSearcher getInstance();
	
	public void setUp() throws Exception
	{
		searcher = getInstance(); 
	}
	
	public void testStringSearchBoundaryCase()
	{
		String src = null;
		String pattern = null;
		int pos = 0;
		pos = searcher.search(src, pattern);
		assertTrue(pos == -1);
		
		src = null;
		pattern = "ABC";
		pos = searcher.search(src, pattern);
		assertTrue(pos == -1);

		src = "ABCDEFG";
		pattern = null;
		pos = searcher.search(src, pattern);
		assertTrue(pos == -1);
		Util.log(searcher, "testStringSearchBoundaryCase() success");
	}
	
	public void testStringSearchNormalCase()
	{
		String src = null;
		String pattern = null;
		int pos = 0;
		src = "XABCDEFG";
		pattern = "ABC";
		pos = searcher.search(src, pattern);
		assertTrue(pos == 1);
		Util.log(searcher, "testStringSearchNormalCase() success");
	}
	
	public void testStringSearchAtBeginningCase()
	{
		String src = null;
		String pattern = null;
		int pos = 0;
		src = "ABCDEFG";
		pattern = "ABC";
		pos = searcher.search(src, pattern);
		assertTrue(pos == 0);
		Util.log(searcher, "testStringSearchAtBeginningCase() success");
	}
	
	public void testStringSearchAtEndCase()
	{
		String src = null;
		String pattern = null;
		int pos = 0;
		src = "AEHBAXDF";
		pattern = "AXDF";
		pos = searcher.search(src, pattern);
		assertTrue(pos == 4);
		Util.log(searcher, "testStringSearchAtEndCase() success");
	}
	
	public void testStringSearchNonExistedCase()
	{
		String src = null;
		String pattern = null;
		int pos = 0;
		src = "AEHBCDEIOFGGAXDF";
		pattern = "MMMM";
		pos = searcher.search(src, pattern);
		assertTrue(pos == -1);
		Util.log(searcher, "testStringSearchNonExistedCase() success");
	}
	
	public void testStringSearchRepeat()
	{
		String src = null;
		String pattern = null;
		int pos = 0;
		src = "ABCABCEABCDEF";
		pattern = "ABCD";
		pos = searcher.search(src, pattern);
		assertTrue(pos == 7);
		Util.log(searcher, "testStringSearchRepeat() success");
	}
	
	public void testStringSearchBigString()
	{
		String src = null;
		String pattern = null;
		int pos = 0;
		src = "UHVTPMNJGLFAECBGGTGWFITBMYGTYJDYNYMRLWPNJXVYPTPXXKAYWBTSTBWNESRUYEDOMSTYDITZPANTKBPHPFHDWXIMETYLMFDUTRAJNOYPWGTAMQJHNNZZAIWLGNCBNDYJAAQFEHAJSTDLSXXPPALQJSLWQKBOQBIBLZDIXXZTXLMDJNCZLJILITITSBUIKUQGWNXRJULJDJAMEYGRCPPZBWCMSBEXKOSQAZCBZFVSKBXOQPJBPHSMNJEVAPIJQYFDJAMHTQGAMABGFFUDWFFBLXDMOAOICAVGUXQGYDEVAOLGWTFCYMZBYLTTFNWMHBANHCJWWWZBJYWCBGRLVDTKVYXVFIKWGVNBZKPNCJQRJDJRNYVYBJOLHNXHJCAJWBNQWFIQOPTNHLIOKKNVUJILRUJNPISDWSCQGPIARNGHHTLJTSRUWDNMMIQVAIZHXQANPEHOFZMQTFBDGUNXAQUXJFMQEQTBKHQHHARLITWCYVDJTSGZOJOBVDCUQNLAZIKPMCZHFRKOOBQBJXMWAYBMHEPMZRMJQJQGCGHRSUSQGDEWSBBGYITZVHRWRFGKOMHSBDKKBSFLGWJXMCRSXDQHAQYECKGMVXQRJATGNCZOGAEJQGCIZISLCBAXWJSGOUVNMTETPYHSCCEXTLEZABLTQMAXLRIBFPMOWXIUNSUPSPVFTEFJGFGYIXCSBAQGRMTPIQJPLNWPAARJEEGEBRAZZTSSCRMDWOJVOOTKUKNVVYDGXJYEIZXCQJWOPTEGXTVEJRMLEFXXXXULKUGNZGTAYDIYZKFWNLPZRROKRLBNHAAPVQREVVYZMYEMSTOTTIWHJRVJIUZCBMEJHBCSDBEQHLBTFUGRYQIZVHECNDRUXCVJQUTZXBLMCYLBZAHODGFZUGSHLIDTKUDQJQLRKBKAWWMEWZHLJGOHNZUAQAVHYTUEGPUCVUXZWJFOLZKXZCDXEHSJZAXTSHDQFJIOUXPPJYUAEABCDUNSVNEC";
		pattern = "ABCD";
		pos = searcher.search(src, pattern);
		assertTrue(pos == 989);
		Util.log(searcher, "testStringSearchBigString() success");
	}
	
	public void testStringSearchFindOccurrence()
	{
		String src = null;
		String pattern = null;
		int count = 0;
		src = "BCDABCDEBCEXBCDGBCBCD";
		pattern = "MBCDM";
		count = searcher.findOccurrence(src, pattern);
		assertTrue(count == 0);
		src = "BCDABCDEBCEXBCDGBCBCD";
		pattern = "BCD";
		count = searcher.findOccurrence(src, pattern);
		assertTrue(count == 4);
		Util.log(searcher, "testStringSearchFindOccurrence() success");
	}
	
	public void testStringSearchFindOccurrenceInBigString()
	{
		String src = null;
		String pattern = null;
		int count = 0;
		src = "ABCTXWZXFIGYRNXRUIPVNXDTYABCUVZHIUMJXTULAQGMMLLKJAIKMMTWWFEHNSTTUFBEVLDSGYNXNGYGXUXZPEQBMHWEABCHDOQICKRUOAEFMBCVSBUICDOABCBZRPYLYRTFSNYZFGPWVCOUXZYHVDFUJOTGDRSYQNIVBBKQMKQNVQJXQODHCLNHLHKEVTACWEWZRZSESNDAPKBGEUDVPXRUBILTPSGOTDUMWSNILVNZVKKRVTXWUYYTORALEXRFKQQCHUFWKJDKCDDOZCXYBXXYYWYNMDBWNMWPFKBXDGHJCTLNJXJPYHQNUFNDQZIORKHDEDMIVPVVASMUSCQRHYNZZSTHGNENEYSWBUCUVXRPSBXFXDNYJDODURRBZUSPVEHLXQDLISWRDHMSDKSPGFJVMNBONCWHSZQCQGADYHBLHAUDXMHZJZGEWQKYQXWUENUTDLIAUCMVCFEEQXRMECMZFIRFMLIHPKVBUNBNBPVLGPAFGVXKEXFEBOKOPAVTXSLWRDVSSGHUDPGUXGRZLJWKBVDRPFUSBRFGICFXWSNALERZASPHBGYWNPOOKQCOBZEMLSUZEPBNSNCDEEMTGTLJAVGAUEXCTNOURWXFADBOKGJAOKKFVBCJSRODFQJMGBLIUJIXUSZJRUNIGTJLTOZZUJELREVAXBSBBULAIWWHTILKBSGKRXQESZGLCHAUCRXTPGRBKCPKJRPVUYGIUSJKDQUFDBLYPLMSKYTFXPOUHOTTOMRXCDWEFATRKAGGZGUGFXSXWPFHYOIXDGPEZZLNVJMPEAXUKUUCCRIHKYJJARZALDYPFZDJEHXCNFTRMBCNHHTCTWRZUUMRLJRWLHVLDMSCAANWQJSSMMZEKKOKSAKDAWLEMHWAHPOPJHJGQKTJSVHENIPULVQWVPYZUPUEJYEEDLNVBWXADFHRTZFLEPOOBYQVGIXYABCXTJWULVXROWJHQZYBBVYAHKGFYRTPFUKNHCLYPCXNPABC";
		pattern = "ABC";
		count = searcher.findOccurrence(src, pattern);
		assertTrue(count == 6);
		Util.log(searcher, "testStringSearchFindOccurrenceInBigString() success");
	}
}
